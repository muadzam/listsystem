package com.example.ListSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ListSystem.model.Customer;
import com.example.ListSystem.repository.CustomerRepository;

@Controller
public class CustomerController 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public String getCustomers(Model model)
	{
		List<Customer> customers = customerRepository.findAll();
		model.addAttribute("customers",customers);
		return "Customer/index";
	}
	
}
