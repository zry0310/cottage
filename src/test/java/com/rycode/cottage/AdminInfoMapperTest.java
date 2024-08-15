package com.rycode.cottage;

import com.rycode.cottage.mapper.AdminInfoMapper;
import com.rycode.cottage.model.AdminInfo;
import com.rycode.cottage.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class AdminInfoMapperTest {

    @Autowired
    AdminInfoMapper adminInfoMapper;

    @Test
    public void test() throws NoSuchAlgorithmException {
//        String passwordHash = MD5Util.encrypt("1" + "X9xK5DC7iU");
        String passwordHash = "9b2e403e25a85f7cd86af51350473c98";
        Map<String,Object> map = new HashMap();
        map.put("name","zry");
        map.put("password",passwordHash);
        List<AdminInfo> adminInfos = adminInfoMapper.selectByMap(map);
        System.out.println(adminInfos);
    }
}
