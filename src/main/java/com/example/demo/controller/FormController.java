package com.example.demo.controller;


import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {




    @GetMapping("/ok/showNewMemberFormForSave")
    public String show(Model model) {

        Member member = new Member();
        model.addAttribute("member", new Member());

        return "member/newMemberForm";
    }

}
