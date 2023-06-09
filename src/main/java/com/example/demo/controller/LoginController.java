package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.config.EazyBankUsernamePwdAuthenticationProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private EazyBankUsernamePwdAuthenticationProvider authProvider;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            authProvider.authenticate(authToken);
        } catch (Exception e) {
            return "redirect:/login?error";
        }

        return "redirect:/";
    }
}
