package com.obs.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.obs.AccuralNotFoundException;
import com.obs.ErrorDetails;
import com.obs.SwaggerTestApplication;
import com.obs.entity.AccrualRule;
import com.obs.repository.AccrualRuleRepository;
import com.obs.service.AccrualRuleService;



@RestController
//@CrossOrigin(allowedHeaders="*",origins="http://localhost:4200")

public class AccrualRuleCtrl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccrualRuleCtrl.class);
	
	@Autowired
	private AccrualRuleService arService ;
	
	@RequestMapping(value="/accrualrule/{value1}/{value2}")
	//@PreAuthorize("hasRole('USER')") 
	@CrossOrigin(origins = "http://localhost:4200")
	public Page<AccrualRule> getAccrualRule(@PathVariable int value1,@PathVariable int value2) {
		
		LOGGER.info("Message logged at info level");
		LOGGER.debug("Message logged at Debug level");
		LOGGER.warn("Message logged at warn level");
		LOGGER.error("Message logged at error level");
		System.out.println(value1+".............."+value2);
		return arService.getAccrualRule(value1,value2);
	}
	
	
	@RequestMapping(value="/accrualrule",method ={RequestMethod.POST})
	//@PreAuthorize("hasRole('USER')")
    @CrossOrigin(origins = "http://localhost:4200")
	public AccrualRule addAccrualRule(@RequestBody AccrualRule accrualRule ){
          System.out.println(accrualRule);
		  return arService.getAddedAccuralRule(accrualRule);

	}
	
	@RequestMapping(value="/delete/{accrualRuleSeqNumber}",method = {RequestMethod.DELETE,RequestMethod.GET})
	//@PreAuthorize("hasRole('ADMIN')") 
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAccrualRule(@PathVariable long accrualRuleSeqNumber){
		arService.deleteAccuralRule(accrualRuleSeqNumber);
	}

	
	
	/*Method when we get one header */
	/*@RequestMapping(value="/accrualrule/{accrualRuleSeqNumber}",method = {RequestMethod.POST,RequestMethod.GET})
	 public  AccrualRule  getAccrualByRule(@RequestHeader(value="device") String request ,@PathVariable long accrualRuleSeqNumber,HttpServletResponse response){ 
		
		System.out.println("device:"+request);
		
		return arService.getAccrualByRule(accrualRuleSeqNumber);
		
	}*/

	/*For multiple header*/
	@RequestMapping(value="/accrualrule/{accrualRuleSeqNumber}",method = {RequestMethod.POST,RequestMethod.GET})
	@CrossOrigin(origins = "http://localhost:4200")
	public  AccrualRule  getAccrualByRule(@RequestHeader Map<String,String> request,@PathVariable long accrualRuleSeqNumber,HttpServletResponse response) throws AccuralNotFoundException { 
		AccrualRule student = arService.getAccrualByRule(accrualRuleSeqNumber);
		  if (student==null) 
		      throw new AccuralNotFoundException("Please Enter valid id"+" "+"accrualRuleSeqNumber"+"--"+accrualRuleSeqNumber+" "+"not present");
		  
		  
		 for (String elem: request.keySet()) {
		      System.out.println(elem + " : " + request.get(elem));
		    }
		
		return arService.getAccrualByRule(accrualRuleSeqNumber);
	}
    
	@RequestMapping(value="/accrualrule/{accrualRuleSeqNumber}",method = {RequestMethod.PUT})
	//@PreAuthorize("hasRole('USER')") 
	@CrossOrigin(origins = "http://localhost:4200")
	public AccrualRule updateAccuralRule (@PathVariable(value = "accrualRuleSeqNumber") Long accrualRuleSeqNumber,
			 @RequestBody AccrualRule accrualRule  ) {
		    return arService.updateAccuralRule(accrualRule,accrualRuleSeqNumber);
		
	}
	private static String UPLOADED_FOLDER = "C:\\Users\\dfgc2249\\Desktop\\pratikshaUpload\\";
   
	

@RequestMapping(value="/upload",method ={RequestMethod.POST})
  public String handleFileUpload(
          @RequestParam("userfile") MultipartFile file ,RedirectAttributes redirectAttributes) throws IOException {
	
	  if (file.isEmpty()) {
          redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
          return "redirect:uploadStatus";
      }
	
	

      try {

          
          byte[] bytes = file.getBytes();
          Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
          Files.write(path, bytes);

          redirectAttributes.addFlashAttribute("message",
                  "You successfully uploaded '" + file.getOriginalFilename() + "'");

      } catch (IOException e) {
          e.printStackTrace();
      }

      return "File Save Successfully..";
  }

	

}
