package com.rycode.cottage;

import com.rycode.cottage.mapper.AdminInfoMapper;
import com.rycode.cottage.model.AdminInfo;
import com.rycode.cottage.service.AdminInfoService;
import com.rycode.cottage.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class AdminInfoServiceTest {

    @Autowired
    AdminInfoService adminInfoService;

    @Test
    public void test() throws NoSuchAlgorithmException {
        String salt = adminInfoService.getSalt("zry");
        String passwordHash = MD5Util.encrypt("1" + salt);
        String name = "zry";
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("password",passwordHash);
        List<AdminInfo> adminInfos = adminInfoService.getAdminInfoList(map);
        System.out.println((adminInfos.isEmpty())?"密码错误":adminInfos.get(0));
    }
}
