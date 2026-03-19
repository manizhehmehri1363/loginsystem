package com.example.loginsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    // صفحه ورود
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // داشبورد کاربر
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");

        // اگر کاربر وارد نشده، بازگرداندن به صفحه ورود
        if (username == null || username.isEmpty()) {
            return "redirect:/login";
        }

        // افزودن اطلاعات کاربر به مدل
        model.addAttribute("username", username);
        model.addAttribute("message", "Willkommen bei Junior Senior GmbH");

        return "dashboard";
    }
}