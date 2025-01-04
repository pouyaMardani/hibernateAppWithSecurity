package com.example.demo.controller.member;


import com.example.demo.entity.member.Member;
import com.example.demo.service.employee.EmployeeService;
import com.example.demo.service.member.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/member")
public class MemberController {


    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/showMembers")
    public String listOfShowMembers(Model theModel) {

        List<Member> members = memberService.findAll();
        theModel.addAttribute("members",members);

        return "member/listMemberForm";
    }

    @GetMapping("/list")
    public String listOfEmp(Model theModel) {
        return "employee/list-employees";
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("member") Member member, BindingResult bindingResults) {

        if (bindingResults.hasErrors()) {
            return "employee/employeeForm";
        } else {
            memberService.save(member.getUsername(),member.getPassword());
            return "redirect:/loginPage";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

       /* employeeService.deleteById(theId);*/
        return "redirect:/employees/list";

    }

}
