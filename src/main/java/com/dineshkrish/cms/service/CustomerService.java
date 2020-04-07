package com.dineshkrish.cms.service;

import com.dineshkrish.cms.dao.CustomerDAO;
import com.dineshkrish.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    @Autowired private CustomerDAO customerDAO;
    private int customerIdCount =1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();
    public Customer addCustomer(Customer customer){
       /* customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount ++;
        return customer;*/
       return customerDAO.save(customer);
    }
    public Customer getCustomer(int customerId){
        Optional<Customer> customerOptional =null ;
        try {
            customerOptional = customerDAO.findById(customerId);
        } catch (Exception x)
        {
            System.out.println(x);
        }
       return customerOptional.get();
    }
    public List<Customer> getCustomers(){
       /* return customerList;*/
        return customerDAO.findAll();
    }
    public Customer updateCustomer(int customerId,Customer customer){
   /*     customerList.stream().forEach(c ->{
            if (c.getCustomerId() == customerId){
                c.setCustomerEmail(customer.getCustomerEmail());
                c.setCustomerFisrtName(customer.getCustomerFisrtName());
                c.setCustomerLastName(customer.getCustomerLastName());
            }
        });
        return customerList.stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();*/
   customer.setCustomerId(customerId);
   return customerDAO.save(customer);
    }
    public void deleteCustomer(int customerId){
        /*customerList.stream().forEach(c->{
                if (c.getCustomerId() == customerId){
                    customerList.remove(c);
                }
        });*/
        customerDAO.deleteById(customerId);

    }
}
