package com.jumia.phones.controller;


import com.jumia.phones.dto.PhoneDto;
import com.jumia.phones.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:9090/")

public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @GetMapping("/phones")
    public ResponseEntity<List<PhoneDto>> getPhones(@RequestParam(name="country",required = false) String country, @RequestParam(name="state",required = false) String state) {
        List<PhoneDto> phoneDtoList = phoneService.getPhones(country,state);

        return new ResponseEntity<>(phoneDtoList, HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getCountries() {
        List<String> countries = phoneService.getCountries();

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
