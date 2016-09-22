package com.vedha.tgservice.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;
@Log4j
public class FormValidation {
	
	public static boolean validatePhoneno(String numberValue)
	{           
		        String MOBILE_PATTERN = "[0-9]{10}";
		        Pattern phoneNopattern = Pattern.compile(MOBILE_PATTERN);
		        Matcher phoNummatcher =phoneNopattern.matcher(numberValue);
	            if (! phoNummatcher.matches())
				{
						return true;
				}
				else
				{
                        return false;
								
				}
	}
	
	public static boolean validateemail(String emailValue){
		     
			//boolean status=false;
		      // log.debug("Enter email Validation :"+emailValue);
               log.info("value:"+emailValue);
             //  String EMAIL_PATTERN="^.+@.+\\..+$";
              String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + 
       				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
               Pattern emailIdpattern = Pattern.compile(EMAIL_PATTERN);
               Matcher emailmatcher=emailIdpattern.matcher(emailValue);
              if(! emailmatcher.matches())
              {
            	  log.info("check if side");
    	              return true;
    	            
              }
              else
              {
            	  log.info("check else side");
    	              return false;
              }
             // return status;
   }  
	
	public static boolean validateAlphabet(String alphabetValue)
	{         
		      String ALPHABET_PATTERN = "[a-zA-Z]+";
	          Pattern pattern = Pattern.compile(ALPHABET_PATTERN);
	          Matcher namematcher = pattern.matcher(alphabetValue);
	         if(!namematcher.matches())
	         {
	                  return true;
	         }
	          else
	         {
	                  return false;
	         }

	}
	
	public static boolean validateID(String idValue)
	{         
	    System.out.println("Value:::::"+idValue);
		      String ID_PATTERN = "[0-9]+";
	          Pattern pattern = Pattern.compile(ID_PATTERN);
	          Matcher idmatcher = pattern.matcher(idValue);
	         if(!idmatcher.matches())
	         {
	                  return true;
	         }
	          else
	         {
	                  return false;
	         }

	}
	
	public static boolean validatePanNum(String panNumValue){
		
		 String PAN_NUM_PATTERN ="[A-Z]{5}[0-9]{4}[A-Z]{1}";
         Pattern pattern = Pattern.compile(PAN_NUM_PATTERN);
         Matcher panNummatcher = pattern.matcher(panNumValue);
        if(!panNummatcher.matches())
        {
                 return true;
        }
         else
        {
                 return false;
        }
		
	}
    
 }
