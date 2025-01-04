package com.example.demo.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/loginPage")
    public String authenticated(){
        return "others/login-Page";
    }


    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "others/access-denied";
    }


}
