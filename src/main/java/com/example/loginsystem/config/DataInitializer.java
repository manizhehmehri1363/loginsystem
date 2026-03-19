package com.example.loginsystem.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.loginsystem.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        createTestUsers();
    }

    /**
     * ایجاد کاربران تست هنگام راه‌اندازی برنامه
     */
    private void createTestUsers() {
        userService.registerUser("admin", "admin123");
        userService.registerUser("user", "user123");

        System.out.println("=================================");
        System.out.println("Test Users Created:");
        System.out.println("admin / admin123");
        System.out.println("user / user123");
        System.out.println("=================================");
    }
}