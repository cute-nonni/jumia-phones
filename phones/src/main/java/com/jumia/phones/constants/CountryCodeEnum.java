package com.jumia.phones.constants;

import java.util.stream.Stream;

public enum CountryCodeEnum {

    CAMEROON("237", "Cameroon","\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("251", "Ethiopia","\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("212", "Morocco","\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("258", "Mozambique","\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("256", "Uganda","\\(256\\)\\ ?\\d{9}$");

    public final String code;
    public final String country;
    public final String regex;



    private CountryCodeEnum(String code, String country, String regex) {
        this.code = code;
        this.country = country;
        this.regex=regex;
    }

    public static Stream<CountryCodeEnum> stream() {
        return Stream.of(CountryCodeEnum.values());
    }

}
