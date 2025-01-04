package com.example.demo.controller.employee;


import com.example.demo.entity.employee.Employee;
import com.example.demo.service.employee.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/list")
    public String listOfEmp(Model theModel) {

        List<Employee> employees = employeeService.findAllByOrderByFirstNameAsc();

        theModel.addAttribute("employees", employees);

        return "employee/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String show(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", new Employee());

        return "employee/employeeForm";
    }

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("employeeId") int theId, Model model) {

        Employee employee = employeeService.findById(theId);
        model.addAttribute("employee", employee);

        return "employee/employeeForm";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResults) {

        if (bindingResults.hasErrors()) {
            return "employee/employeeForm";
        } else {
            employeeService.save(emp);
            return "redirect:/employees/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        employeeService.deleteById(theId);
        return "redirect:/employees/list";

    }

}
