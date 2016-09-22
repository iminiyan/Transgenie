package com.vedha.tgservice.exception;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class ParameterFormat.
 */
public class ParameterFormat {
    
    /** The map. */
    private static Map<String, String[]> map;
    static {
        map = new HashMap<String, String[]>();
        //# Cusine Field  Pattern String for Matching
        map.put("cusineName", new String[] { "^([a-zA-Z0-9])([ A-Za-z0-9_@./#&+-,!%&^'])*{3,45}$", "Cusine must be between 3 to 45 With Alphanumeric and Space" });
        map.put("cityName", new String[] { "[a-zA-Z0-9][a-zA-Z0-9 ]{3,75}", "City must be between 3 to 75 With Alphanumeric and Space" });
        map.put("Location", new String[] { "[a-zA-Z0-9][a-zA-Z0-9 ]{3,75}", "Location must be between 3 to 75 With Alphanumeric and Space" });
        map.put("MerchantCategory", new String[] { "^([a-zA-Z0-9])([ A-Za-z0-9_@./#&+-,!%&^'])*{3,45}$", "Merchant Category must be between 3 to 45 With Alphanumeric and Space" });
        map.put("MerchantSpeciality", new String[] { "^([a-zA-Z0-9])([ A-Za-z0-9_@./#&+-,!%&^'])*{3,45}$", "Merchant Speciality must be between 3 to 45 With Alphanumeric and Space" });
        map.put("MerchantBank", new String[] { "[a-zA-Z0-9]+([a-zA-Z0-9 _-])*{3,100}", "Merchant Bank must Start with alphabet and also contains 3 to 100 With Alphanumeric and Space" });
        map.put("FoodCategory", new String[] { "[a-zA-Z0-9]+([a-zA-Z0-9 ])*{3,45}", "Food Category must Start with alphabet and also contains 3 to 45 With Alphanumeric and Space" });
        //# Deal Creation and Updation Fields Pattern String for Matching
        map.put("dealName", new String[] { "([a-zA-Z0-9 ])(.*){3,45}",
        "DealName must be between 4 and 40 characters, and may contain only alphanumerics, -, _, and spaces" });
        map.put("dealDetail", new String[] { "([a-zA-Z0-9 ])(.*){3,150}",
        "DealDetail must be between 4 and 150 characters, and may contain only alphanumerics, -, _, and spaces" });
        map.put("dealDate",  new String[] {"^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[1-2]{1}[0-9]{3}$",
        		"Deal start and End Date Must Be in this format DD-MM-YYYY " });
        map.put("openingQuantity", new String[] { "[1-9][0-9]{1,5}", "Opening Quantity must be exactly 1 to 5 digits." });
        map.put("foodtype", new String[] { "VEG|NON_VEG", "The food type must be either 'VEG' or 'NON_VEG'." });
        map.put("parameter", new String[] { ".*", " " });
        map.put("dob", new String[] { ".*", " " });
        map.put("title", new String[] { ".*", " " });
        map.put("firstName", new String[] { "[a-zA-Z][a-zA-Z'. ]{1,39}",
                "First name must be between 2 and 40 characters, start with an alphabet, and may contain only alphabet, space, and '." });
        map.put("middleName", new String[] { "[a-zA-Z][a-zA-Z'. ]{1,39}",
                "Middle name must be between 2 and 40 characters, start with an alphabet, and may contain only alphabet, space, and '." });
        map.put("lastName", new String[] { "[a-zA-Z][a-zA-Z'. ]{1,39}",
                "Last name must be between 2 and 40 characters, start with an alphabet, and may contain only alphabet, space, and '." });
        map.put("cardHolderName", new String[] { "[a-zA-Z][a-zA-Z'. ]{1,49}",
                "Card Holder Name name must be between 2 and 50 characters, start with an alphabet, and may contain only alphabet, space, and '." });
        map.put("suffix", new String[] { ".*", " " });

        map.put("date",  new String[] {"^[1-2]{1}[0-9]{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", " " });
        map.put("startDate", new String[] { ".*", " " });
        map.put("endDate", new String[] { ".*", " " });
        map.put("isPrimary", new String[] { ".*", " " });

        map.put("username", new String[] { "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", "invalid email format" });
        map.put("password", new String[] { "[a-zA-Z0-9#@$_-]+", "invalid password format" });
        // map.put("username", new String[] { "[a-zA-Z][a-zA-Z0-9_-]{4,19}",
        // "user name must be between 5 and 20 characters, start with an alphabet and may contain only alphanumerics, -, and _" });

        map.put("postal", new String[] { "[0-9]{5}", "Zip code must be exactly 5 digits long." });
        map.put("country", new String[] { "[0-9]{3}", "The issuing country length can not be more than 3 digits." });
        map.put("issuingCountry", new String[] { "840", "The country should be 840, which is three digit numeric code for USA." });
        map.put("address1", new String[] { "[a-zA-Z0-9][a-zA-Z0-9 _.#-]{1,39}",
                "address1 must start with an alphanumetic, must be between 2 and 40 characters, and may contain only alphanumerics, ., -, _, #, and spaces" });
        map.put("address2", new String[] { "[a-zA-Z0-9][a-zA-Z0-9 _.#-]{1,39}",
                "address2 must start with an alphanumeric, must be between 2 and 40 characters, and may contain only alphanumerics, ., -, _, #, and spaces" });
        map.put("city", new String[] { "[a-zA-Z0-9][a-zA-Z0-9 _-]{1,39}",
                "city must be between 2 and 40 characters, and may contain only alphanumerics, -, _, and spaces" });
        map.put("region", new String[] { "[a-zA-Z]{2}", "region code should be exactly 2 characters" });
        map.put("phoneNumber", new String[] { "[1-9][0-9]{9}", "phone numbers must be exactly 10 digits." });
        map.put("mobilePhone", new String[] { "[1-9][0-9]{9}", "mobile numbers must be exactly 10 digits." });
        map.put("identityNumber", new String[] { "[0-9a-zA-Z][0-9a-zA-Z _-]{2,19}",
                "identity number numbers must be between 3 and 20 characters and contain alphanumerics, -, space, and _." });
        map.put("emailAddress", new String[] { "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                "email address is in incorrect format." });
        map.put("email", new String[] { "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                "email address is in incorrect format." });

        map.put("decision", new String[] {"APPROVED|REJECTED", "The decision must be either 'APPROVED' or 'REJECTED'." });
        map.put("nameType", new String[] {"PERSON|COMPANY", "The name type must be either 'COMPANY' or 'PERSON'." });
        map.put("option", new String[] {"all|latest", "The option must be either 'all' or 'latest'." });
        map.put("customerId", new String[] {"[1-9][0-9]{0,16}", "The customer ID must by numeric and should not start with 0." });
        map.put("bankAccountNumber", new String[] {"[a-zA-Z0-9][a-zA-Z0-9]{3,19}",
                "Account number must be between 4 and 20 and may contain only alphanumerics" });
        map.put("accountNumber", new String[] {"[0-9]{4,17}", "Account number must be between 4 and 17 and may contain only digits" });
        map.put("routingNumber", new String[] {"[0-9]{9}", "Routing number must be exactly 9 digits." });
        map.put("bankAccountType", new String[] {"SAVING|CHECKING", "Bank Account type must be either 'SAVING' or 'CHECKING'." });
        map.put("beneficiaryId", new String[] {"[0-9]{1,16}", "Beneficiary Id must be between 1 and 16 digits long" });
        map.put("bpcAccountId", new String[] {"[0-9]{1,16}", "Bpc Account Id must be between 1 and 16 digits long" });
        map.put("cardNumber", new String[] {"[0-9]{10,20}", "Card Number must be between 10 and 20 digits long" });
        map.put("expiryDate", new String[] {"2[0-9]{3}(0[1-9]|1[0-2])", "Expiry date should be in YYYYMM format" });
        
        map.put("name", new String[] {"[a-zA-Z][a-zA-Z']{1,39}",
        "District name between 2 and 40 characters, start with an alphabet, and may contain only alphabet, space" });
        map.put("code", new String[] {"[0-9]{2}", "District Code must be exactly 2 digits." });
        map.put("stateId", new String[] {"[0-9]{2}", "state Code must be exactly 2 digits." });
        map.put("languageId", new String[] {"[1-9]{1}", "languageId must be exactly 1 digits." });
        map.put("languageCode", new String[] {"[1-9]{2}", "languageCode must be exactly 2 digits." });
        map.put("fpscode", new String[] {"[0-9]{1,5}", "FPS Code must be numeric and length should be with in 5"});
        
        //device  registration validation
        map.put("serialNumber", new String[] {"[a-zA-Z0-9]{4,21}",
        		"Device serial number should only contain alphanumeric character and must be between 15 and 20 long"});
        map.put("imeiNo", new String[] {"[0-9]{14,17}",
        		"Device serial number should only contain alphanumeric character and must be between 15 and 20 long"});
        map.put("deviceParameter", new String[] {"[A-Za-z0-9-]+","Device details should be not empty"});
        map.put("sdkVersion", new String[] {"[0-9-]+","Sdk version should not be empty and may contain only digits"});
        
        //HeartBeat service 
        map.put("fpsId", new String[] {"[0-9]+","FpsStore Id should not be empty and may contain only digits"});
        
        //Device service
        map.put("deviceNumber",new String[] {"[a-z]{1,60}","device number should be in String"}); 
        map.put("sim",new String[] {"[a-z]{1,80}","sim number should be in String"});
        
        //godown stock outward service
        map.put("godownId", new String[] {"[0-9]+","godownId should not be empty and may contain only digits"});
        map.put("productId", new String[] {"[0-9]+","product should not be empty and may contain only digits"});
        map.put("quantity", new String[] {"[0-9.]+","quantity may contain only digits"});
        map.put("fpsReceiQuantity", new String[] {"[0-9.]+","fpsReceiQuantity may contain only digits"});
        map.put("deliveryChallanId", new String[] {"[0-9]+","deliveryChallanId may contain only digits"});
        map.put("godownCode",new String[] {"[a-zA-Z]+","godowncode should be in String only"}); 
        map.put("godownname",new String[] {"[a-zA-Z]+","godownname should only be in String only"}); 
        map.put("talukcode",new String[]{"[a-z]","talukcode should only be in String"}); 
        map.put("talukname",new String[]{"[a-z]","talukname should only be in String"}); 
        map.put("districtname", new String[]{"[a-z]","districtname should only be in string"}); 
        map.put("districtcode",new String[] {"[a-z]","districtcode should only be in String"});
        map.put("villagecode",new String[]{"[a-z]","villagecode must be in String"}); 
        map.put("villagecode",new String[]{"[a-z]","villagecode must be in String"}); 
        map.put("createdBy", new String[] {"[0-9.]+","createdBy may contain only digits"});
        map.put("quantity", new String[] {"[0-9.-]+","quantity may contain only digits"});
        map.put("batchNo", new String[] {"[0-9]+","batchNo may contain only digits"});
        map.put("modifiedQuantity", new String[] {"[0-9]+","modifiedQuantity may contain only digits"});
        map.put("status",new String[]{"[a-z]","status must be in String"}); 
        map.put("talukOffiApproval",new String[]{"[a-z]","talukOffiApproval must be in String"}); 
        map.put("stockLevel",new String[]{"[0-9]",  "stockLevel may contain only digits"});
        map.put("rmns", new String[] {"[0-9.-]+","rmns may contain only digits"});
        map.put("stockThresholdLevel",new String[]{"[0-9]",  "stockThresholdLevel may contain only digits" }); 
        map.put("errorcode",new String[]{"[0-9]","error code muat be integer"}); 
        map.put("errorcodedecription",new String[]{"[a-z]","error decription must be in String"});
        map.put("id",new String[]{"[0-9]","id must be in integer"});
        map.put("beneAppName", new String[]{"[[A-Za-z]+[ \\.]?[a-zA-Z]+]{3,75}","Beneficiary name must be a numeric and length should be exactly 3"});
        map.put("beneAppGender", new String[]{"^(?:Male|Female|Other)","Please enter a valid gender"});
        map.put("beneNationnality", new String[]{"^(?:Indian|Other)","Please enter a valid gender"});
        map.put("voterCard", new String[]{"[A-Z]{3}[0-9]{7}","Please enter a valid Election Id Card No"});
        map.put("uid",new String[]{"[1-9][0-9]{11}", "Aadhaar should be of length 12 and 1st letter should not be zero(0)"});
    }
    
    /**
     * Gets the pattern and error message.
     * @param key the key
     * @return the pattern and error message
     */
    public static String[] getPatternAndErrorMessage(String key) {
        return (String[]) map.get(key);
    }
}
