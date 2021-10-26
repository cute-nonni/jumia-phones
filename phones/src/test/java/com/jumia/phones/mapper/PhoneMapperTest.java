package com.jumia.phones.mapper;

import com.jumia.phones.constants.CountryCodeEnum;
import com.jumia.phones.constants.PhoneNumberStateEnum;
import com.jumia.phones.entity.Customer;
import com.jumia.phones.dto.PhoneDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneMapperTest {

    @Test
    void map_withValidEntity_returnValidDto() {
        Customer customer=new Customer();
        customer.setPhone("(251) 988200000");
        PhoneDto phoneDto = PhoneMapper.map(customer);
        assertEquals(CountryCodeEnum.ETHIOPIA.code, phoneDto.getCode());
        assertEquals(CountryCodeEnum.ETHIOPIA.country, phoneDto.getCountry());
        assertEquals(PhoneNumberStateEnum.VALID.displayName,phoneDto.getState());
        assertEquals("988200000",phoneDto.getPhone());


    }
}