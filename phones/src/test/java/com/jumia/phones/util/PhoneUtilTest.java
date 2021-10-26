package com.jumia.phones.util;

import com.jumia.phones.constants.CountryCodeEnum;
import com.jumia.phones.constants.PhoneNumberStateEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneUtilTest {

    final String VALID_PHONE ="(251) 988200000";
    final String IN_VALID_PHONE ="823564";
    final String EMPTY_STR="";
    final String COUNTRY=CountryCodeEnum.ETHIOPIA.country;
    final String CODE= CountryCodeEnum.ETHIOPIA.code;
    final String STATE= PhoneNumberStateEnum.VALID.displayName;
    final String PHONE ="988200000";




    @Test
    void getCountry() {
        assertEquals(COUNTRY,PhoneUtil.getCountry(VALID_PHONE));
        assertEquals(EMPTY_STR,PhoneUtil.getCountry(IN_VALID_PHONE));

    }

    @Test
    void getState() {
        assertEquals(STATE,PhoneUtil.getState(VALID_PHONE));
        assertEquals(EMPTY_STR,PhoneUtil.getState(IN_VALID_PHONE));

    }
    @Test
    void getCode() {
        assertEquals(CODE,PhoneUtil.getCode(VALID_PHONE));
        assertEquals(EMPTY_STR,PhoneUtil.getCode(IN_VALID_PHONE));

    }
    @Test
    void getPhone_valid() {
        assertEquals(PHONE,PhoneUtil.getPhone(VALID_PHONE));
        assertEquals(EMPTY_STR,PhoneUtil.getPhone(IN_VALID_PHONE));

    }
    @Test
    void isPhoneNumberWithCode() {

        assertTrue(PhoneUtil.isPhoneNumberWithCode(VALID_PHONE));
        assertFalse(PhoneUtil.isPhoneNumberWithCode(null));
        assertFalse(PhoneUtil.isPhoneNumberWithCode(EMPTY_STR));
        assertFalse(PhoneUtil.isPhoneNumberWithCode(IN_VALID_PHONE));




    }
}