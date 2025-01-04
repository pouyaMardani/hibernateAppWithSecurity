package com.example.demo.controller.member;


import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.role.RoleType;
import com.example.demo.service.employee.EmployeeService;
import com.example.demo.service.member.MemberService;
import com.example.demo.service.role.RoleService;
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

    private RoleService roleService  ;

    public MemberController(MemberService memberService,RoleService roleService) {
        this.memberService = memberService;
        this.roleService = roleService;
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


    /*------------------------------UPDATE ACCESS-----------------------------*/

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("memberId") Long memberId, Model model) {

        Member member = memberService.findById(memberId.intValue());
        model.addAttribute("member", member);

        return "member/memberAccess";
    }
    @PostMapping("/changeAccess")
    public String changeAccess(@ModelAttribute("member") Member member) {

        roleService.findByUserId(member.getId(),member.getAccess());
        return "member/listMemberForm";
    }

   /* @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

       *//* employeeService.deleteById(theId);*//*
        return "redirect:/employees/list";

    }*/

}
