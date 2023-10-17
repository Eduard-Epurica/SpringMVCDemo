package com.eduard.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // Add a new controller method to show the initial HTML form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Add a controller method to actually process the HTMl form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // Add a new controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "YO! " + theName;

        // add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }

    @RequestMapping("/testForm")
    public String testEnvironment(HttpServletRequest request, Model model){
        String testEnv = request.getParameter("studentName");

        model.addAttribute("testmsg", testEnv);

        return "hello";
    }

    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String theName,
                                Model model){

        // convert data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hello! " + theName + ". We are now using @RequestParam";

        // add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }


}
