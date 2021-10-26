package com.jumia.phones.service;


import com.jumia.phones.entity.Customer;
import com.jumia.phones.repository.PhoneRepository;
import com.jumia.phones.constants.CountryCodeEnum;
import com.jumia.phones.dto.PhoneDto;
import com.jumia.phones.mapper.PhoneMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<PhoneDto> getPhones(String country, String state) {

        List<PhoneDto> phoneDtoList;
        List<Customer> customerEntityList = phoneRepository.findAll();

        phoneDtoList = customerEntityList.stream().map(entity -> PhoneMapper.map(entity)).collect(Collectors.toList());

        return phoneDtoList.stream().filter(dto -> valuesEqual(country, dto.getCountry()))
                .filter(dto -> valuesEqual(state, dto.getState())).collect(Collectors.toList());
    }

    private boolean valuesEqual(String userInput, String dtoValue) {
        return StringUtils.isEmpty(userInput) || StringUtils.equalsIgnoreCase(userInput, dtoValue);

    }


    public List<String> getCountries() {

        return CountryCodeEnum.stream().map(entry -> entry.country).collect(Collectors.toList());
    }
}
