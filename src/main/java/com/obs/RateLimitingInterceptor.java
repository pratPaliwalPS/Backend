package com.obs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component

public class RateLimitingInterceptor extends HandlerInterceptorAdapter {

    //@Value("${rate.limit.enabled}")
    @Value("true")
    private boolean enabled;

     

    //@Value("${rate.limit.hourly.limit}")
    @Value("3")
    private int hourlyLimit;

 
    private Map<String, SimpleRateLimiter> limiters = new ConcurrentHashMap<>();

     

    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)

            throws Exception {

        if (!enabled) {

            return true;

        }
        String device =  request.getHeader("device");
       System.out.println("haeder is : "+device);
  
        if (device == null) {
                 return true;

        }

        SimpleRateLimiter rateLimiter = getRateLimiter(device);

        boolean allowRequest = rateLimiter.tryAcquire();


        if (!allowRequest) {

            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());

        }

        response.addHeader("X-RateLimit-Limit", String.valueOf(hourlyLimit));
      System.out.println("allowRequest   "+allowRequest);
        return allowRequest;

    }

     

    private SimpleRateLimiter getRateLimiter(String device) {

        if (limiters.containsKey(device)) {

            return limiters.get(device);

        } else {

            synchronized(device.intern()) {

                if (limiters.containsKey(device)) {

                    return limiters.get(device);

                }

                SimpleRateLimiter rateLimiter = getRateLimiter(device);
                limiters.put(device, rateLimiter);

                return rateLimiter;

            }

        }

    }

     

    @PreDestroy

    public void destroy() {

        // loop and finalize all limiters

    }

}
