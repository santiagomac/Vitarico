package com.example.Vitarico.controller;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.dto.CustomerDto;
import com.example.Vitarico.domain.services.interfaces.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.getCustomer(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.created(URI.create("/api/customer"))
            .body(this.customerService.saveCustomer(customerDto));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        this.customerService.updateCustomer(id, customerDto);
        return ResponseEntity.noContent()
            .build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
