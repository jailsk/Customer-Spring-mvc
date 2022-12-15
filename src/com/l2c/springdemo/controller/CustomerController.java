package com.l2c.springdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.l2c.springdemo.entity.Customer;
import com.l2c.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the customer Service
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel)
	{
		List<Customer> theCustomers= customerservice.getCustomer();
		
		theModel.addAttribute("Customers",theCustomers);
		
		return "customer_list";
	}
	
	@GetMapping("/showformforadd")
	public String showformforadd(Model theModel)
	{
		Customer theCostomer= new Customer();
		
		theModel.addAttribute("customer", theCostomer);
		
		
		return "customer_form";
	}
@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
{
	customerservice.saveCustomer(theCustomer);
	

return "redirect:/customer/list";
}

@GetMapping("showFormForUpdate")
public String updateCustomer(@RequestParam("customerId") int theId,Model theModel)
{
	Customer theCustomer =customerservice.getCustomers(theId);

theModel.addAttribute("customer", theCustomer);
	
	
return "customer_form";	
}

@GetMapping("/ForDelete")
public String ForDelete(@RequestParam("customerId") int theId,Model theModel)
{
	customerservice.deleteCustomer(theId);
	

return "redirect:/customer/list";
}

}

