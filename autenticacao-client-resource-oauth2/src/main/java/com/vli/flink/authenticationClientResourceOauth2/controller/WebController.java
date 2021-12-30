package com.vli.flink.authenticationClientResourceOauth2.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vli.flink.authenticationClientResourceOauth2.persistence.model.Customer;
import com.vli.flink.authenticationClientResourceOauth2.persistence.repository.ICustomerRepository;

//@RestController
@Controller
@RequestMapping(value = "/frontend")
public class WebController {

    @Autowired
    private ICustomerRepository customerRepository;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    @GetMapping(path = "/foos")
    public String customers(Principal principal, Model model) {
        addCustomers();
        Iterable<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    @GetMapping(path = "/user")
    public String user(Principal principal, Model model) {
        model.addAttribute("userString", principal.toString());
        return "userInfo";
    }


    // add customers for demonstration
    public void addCustomers() {
        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customerRepository.save(customer3);
    }
}