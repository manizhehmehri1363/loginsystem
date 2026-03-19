package com.example.loginsystem.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.loginsystem.model.User;
import com.example.loginsystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * ثبت یک کاربر جدید با رمز عبور رمزنگاری شده
     *
     * @param username نام کاربری
     * @param rawPassword رمز عبور خام
     * @return شیء User ثبت شده
     */
    public User registerUser(String username, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        return userRepository.save(user);
    }

    /**
     * اعتبارسنجی کاربر با نام کاربری و رمز عبور
     *
     * @param username نام کاربری
     * @param rawPassword رمز عبور خام
     * @return true در صورت موفقیت اعتبارسنجی، false در غیر این صورت
     */
    public boolean authenticate(String username, String rawPassword) {
        return userRepository.findByUsername(username)
                .map(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .orElse(false);
    }

    /**
     * یافتن کاربر بر اساس نام کاربری
     *
     * @param username نام کاربری
     * @return شیء User در صورت موجود بودن، null در غیر این صورت
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}