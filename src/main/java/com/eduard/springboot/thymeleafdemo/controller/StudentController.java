package com.eduard.springboot.thymeleafdemo.controller;

import com.eduard.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    //create a method for showing the form

    @Value("${languages}")
    private List<String> languages;


    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        //create a new student object
        Student theStudent = new Student();

        //add student object as a model attribute
        theModel.addAttribute("student",theStudent);

        //add the list of countries to the model
        theModel.addAttribute("countries",countries);

        //add the list of languages to the model
        theModel.addAttribute("languages",languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    //Bind model attribute to the Student object parameter being passed in
    public String processForm(@ModelAttribute("student") Student theStudent){

        //log the input data that was populated during the showStudentForm method/webpage
        System.out.println("theStudent object: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " with country: " + theStudent.getCountry());

        return "student-confirmation";
    }

}
