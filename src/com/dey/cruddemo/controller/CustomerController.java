package com.dey.cruddemo.controller;

import com.dey.cruddemo.entity.CustomProjectEditor;
import com.dey.cruddemo.entity.Customer;
import com.dey.cruddemo.entity.Project;
import com.dey.cruddemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditor;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void preProcess(WebDataBinder binder){
        PropertyEditor editor = new CustomProjectEditor();
        binder.registerCustomEditor(Project.class, "projects", editor);
    }

    @GetMapping("/list")
    public ModelAndView listCustomer() {
        ModelAndView mav = new ModelAndView("list-customer");
        mav.addObject("customers", customerService.getCustomers());

        return mav;
    }

    @GetMapping("/showRegisterForm")
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView("customer-form");
        mav.addObject("customer", new Customer());

        return mav;
    }

    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customer.getProjects()
                .forEach(p -> p.setId(customerService.getProjectByName(p.getName(), customer.getId()).getId()));

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam("customerId") int Id){
        ModelAndView mav = new ModelAndView("customer-form");
        Customer customer = customerService.getCustomerById(Id);
        mav.addObject("customer", customer);

        return mav;
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int Id){
        customerService.delete(Id);
        return "redirect:/customer/list";
    }
}
