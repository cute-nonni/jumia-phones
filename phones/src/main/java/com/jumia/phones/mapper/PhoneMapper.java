package com.jumia.phones.mapper;

import com.jumia.phones.entity.Customer;
import com.jumia.phones.util.PhoneUtil;
import com.jumia.phones.dto.PhoneDto;
import org.springframework.lang.NonNull;

public class PhoneMapper {


    public static PhoneDto map(@NonNull Customer entity){

        PhoneDto dto = new PhoneDto();
        dto.setId(entity.getId());
        dto.setCountry(PhoneUtil.getCountry(entity.getPhone()));
        dto.setState(PhoneUtil.getState(entity.getPhone()));
        dto.setCode(PhoneUtil.getCode(entity.getPhone()));
        dto.setPhone(PhoneUtil.getPhone(entity.getPhone()).trim());
        return dto;

    }


}
