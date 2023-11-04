package com.example.gardensoft.controller;

import com.example.gardensoft.dto.CustomerDTO;
import com.example.gardensoft.model.Customer;
import com.example.gardensoft.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<Customer> customers = iCustomerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/getList")
    public ResponseEntity<?> getAllCustomerbyPage(@RequestParam(value = "page",defaultValue = "0")Integer page){
        Page<Customer>customerPage=this.iCustomerService.findAllByList(PageRequest.of(page,10));
        return new ResponseEntity<>(customerPage,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        customerDTO.validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        iCustomerService.add(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<CustomerDTO> customerDTOList) {
        iCustomerService.saveAllEmployee(customerDTOList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
