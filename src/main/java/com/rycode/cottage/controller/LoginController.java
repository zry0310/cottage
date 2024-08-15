package com.rycode.cottage.controller;

import com.rycode.cottage.model.AdminInfo;
import com.rycode.cottage.service.AdminInfoService;
import com.rycode.cottage.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    AdminInfoService adminInfoService;

    @PostMapping("/login")
    public Object login(@RequestParam String name, @RequestParam String password) throws NoSuchAlgorithmException {
        String salt = adminInfoService.getSalt(name);
        String passwordHash = MD5Util.encrypt(password + salt);
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password", passwordHash);
        List<AdminInfo> adminInfos = adminInfoService.getAdminInfoList(map);

        if(adminInfos.isEmpty()){
            return null;
        }else{
            return adminInfos.get(0);
        }
    }
}
