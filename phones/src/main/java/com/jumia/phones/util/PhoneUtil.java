package com.jumia.phones.util;

import com.jumia.phones.constants.CountryCodeEnum;
import com.jumia.phones.constants.PhoneNumberStateEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {


    public static String getCountry(String phoneNumber){

        if(!isPhoneNumberWithCode(phoneNumber)) return "";
        return CountryCodeEnum.stream().filter(d -> d.code.equals(getCode(phoneNumber))).findFirst().map(country->country.country).orElseGet(String::new);


    }


    public static String getState(String phoneNumber){

        if(!isPhoneNumberWithCode(phoneNumber)) return "";

        final Optional<CountryCodeEnum> obj = CountryCodeEnum.stream().filter(d -> d.code.equals(getCode(phoneNumber))).findFirst();

        if(obj.isPresent()){
            CountryCodeEnum countryCodeEnum = obj.get();
            boolean matches = phoneNumber.matches(countryCodeEnum.regex);
            if(matches){
                return PhoneNumberStateEnum.VALID.displayName;
            }else{
                return PhoneNumberStateEnum.NOT_VALID.displayName;

            }
        }
        return "";

    }
    public static String getCode(String phoneNumber){

        if(!isPhoneNumberWithCode(phoneNumber)) return "";

        return phoneNumber.substring(phoneNumber.indexOf("(")+1,phoneNumber.indexOf(")"));
    }

    public static String getPhone(String phoneNumber){

        if(!isPhoneNumberWithCode(phoneNumber)) return "";

        return phoneNumber.substring(phoneNumber.indexOf(")")+1).trim();
    }


    static boolean isPhoneNumberWithCode(String phoneNumber){
        if(StringUtils.isEmpty(phoneNumber))
            return false;

            String regex = "\\(\\d{3}\\) [0-9]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNumber);
            return m.matches();
        }


}
