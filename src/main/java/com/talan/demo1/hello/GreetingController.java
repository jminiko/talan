package com.talan.demo1.hello;

import com.talan.demo1.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @Autowired
    CustomerRepository repository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String customers(Model model) {
        model.addAttribute("repository",repository);
        model.addAttribute("customers", repository.findAll());
        return "listcust";
    }
}