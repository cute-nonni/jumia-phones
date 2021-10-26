package com.jumia.phones.constants;

public enum PhoneNumberStateEnum {

    VALID("Valid"),
    NOT_VALID("Not Valid");
    public final String displayName;
    PhoneNumberStateEnum(String displayName){
        this.displayName=displayName;
    }
}
