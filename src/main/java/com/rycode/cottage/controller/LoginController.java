package com.rycode.cottage.controller;

import com.rycode.cottage.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Object login(@RequestParam String name, @RequestParam String password) {
        return userService.login(name, password);
    }

    @PostMapping("/register")
    public Object register(@RequestParam String name, @RequestParam String password) {
        return userService.register(name, password);
    }

    @SneakyThrows
    @PostMapping("/changePwd")
    public Object changePwd(@RequestParam String name, @RequestParam String originPassword, @RequestParam String newPassword) {
        return null;
    }
}
