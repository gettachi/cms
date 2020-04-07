package com.dineshkrish.cms.api;

import com.dineshkrish.cms.model.Customer;
import com.dineshkrish.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResoure {
    @Autowired private CustomerService customerService;
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }
    @GetMapping(value = "/{idCustomer}")
    public Customer getCustomer(@PathVariable("idCustomer") int outIdCustomer){
        return customerService.getCustomer(outIdCustomer);
    }
    @PutMapping(value = "/{idCustomer}")
    public Customer updateCustomer(@PathVariable("idCustomer") int idCustomer,@RequestBody Customer customer){
        return customerService.updateCustomer(idCustomer,customer);
    }
    @DeleteMapping(value = "/{idCustomer}")
    public void deleteCustomer(@PathVariable("idCustomer") int idCustomer){
        customerService.deleteCustomer(idCustomer);
    }

}

