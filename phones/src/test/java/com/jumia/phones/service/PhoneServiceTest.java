package com.jumia.phones.service;

import com.jumia.phones.constants.CountryCodeEnum;
import com.jumia.phones.constants.PhoneNumberStateEnum;
import com.jumia.phones.dto.PhoneDto;
import com.jumia.phones.entity.Customer;
import com.jumia.phones.repository.PhoneRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneServiceTest {

    static PhoneRepository phoneRepository;
    //static List<PhoneDto> phones = new ArrayList<>();
    static List<Customer> phoneEntities = new ArrayList<>();

    @BeforeAll
    public static void init(){
        phoneRepository=mock(PhoneRepository.class);

          Customer entity1= new Customer();
          entity1.setPhone("(258) 042423566");

        Customer entity2= new Customer();
        entity2.setPhone("(256) 704244430");
        phoneEntities.add(entity1);
        phoneEntities.add(entity2);



//        PhoneDto phoneDto1 = new PhoneDto();
//        phoneDto1.setPhone("042423566");
//        phoneDto1.setCode("258");
//        phoneDto1.setCountry(CountryCodeEnum.MOZAMBIQUE.country);
//        phoneDto1.setState(PhoneNumberStateEnum.NOT_VALID.displayName);
//
//        PhoneDto phoneDto2 = new PhoneDto();
//        phoneDto2.setPhone("677046616");
//        phoneDto2.setCode("237");
//        phoneDto2.setCountry(CountryCodeEnum.CAMEROON.country);
//        phoneDto2.setState(PhoneNumberStateEnum.VALID.displayName);

//        phones.add(phoneDto1);
//        phones.add(phoneDto2);
        when(phoneRepository.findAll()).thenReturn(phoneEntities);

    }
    @Test
    void getPhones_findAll() {
        PhoneService phoneService = new PhoneService(phoneRepository);
        List<PhoneDto> phones = phoneService.getPhones(null, null);

        assertNotEquals(0,phones.size());
        assertEquals("258",phones.get(0).getCode());
 }

    @Test
    void getPhones_findByCountry() {
        PhoneService phoneService = new PhoneService(phoneRepository);
        List<PhoneDto> phones = phoneService.getPhones(CountryCodeEnum.MOZAMBIQUE.country, null);

        assertEquals(1,phones.size());
        assertEquals(CountryCodeEnum.MOZAMBIQUE.country,phones.get(0).getCountry());
    }

    @Test
    void getPhones_findByState() {
        PhoneService phoneService = new PhoneService(phoneRepository);
        List<PhoneDto> phones = phoneService.getPhones(null, PhoneNumberStateEnum.NOT_VALID.displayName);

        assertEquals(1,phones.size());
        assertEquals(PhoneNumberStateEnum.NOT_VALID.displayName,phones.get(0).getState());
    }

    @Test
    void getPhones_findByCountryAndState() {
        PhoneService phoneService = new PhoneService(phoneRepository);
        List<PhoneDto> phones = phoneService.getPhones(CountryCodeEnum.UGANDA.country, PhoneNumberStateEnum.VALID.displayName);

        assertEquals(1,phones.size());
        assertEquals(PhoneNumberStateEnum.VALID.displayName,phones.get(0).getState());
    }

    @Test
    void getCountries_returnAll() {
        PhoneService phoneService = new PhoneService(phoneRepository);
        List<String> countries = phoneService.getCountries();
        assertTrue(5==countries.size());


    }


}