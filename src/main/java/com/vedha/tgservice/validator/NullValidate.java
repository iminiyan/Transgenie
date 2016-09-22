package com.vedha.tgservice.validator;

import java.util.Date;

import lombok.extern.log4j.Log4j;
@Log4j
public class NullValidate {
	
	public static boolean validateString(String inputValue)  {
		 
        if (inputValue != null && inputValue.length()>0 ){
         return false;
        }
		 return true;
       }
	
	public static boolean validateInteger(Integer inputValue){
		if(inputValue !=null){
			return false;
		}
		else
		{
			return true;
		}
	 }
	public static boolean validateDate(Date inputValue){
		if(inputValue !=null){
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static boolean validateCharacter(Character inputValue){
		if(inputValue !=null ){
			return false;
		}
		else
		{
			return true;
		}
	 }
	public static boolean validateLong(Long inputValue){
		if(inputValue !=null ){
			return false;
		}
		else
		{
			return true;
		}
	 }
}
