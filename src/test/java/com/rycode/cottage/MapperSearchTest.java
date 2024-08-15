package com.rycode.cottage;

import com.rycode.cottage.mapper.AdminInfoMapper;
import com.rycode.cottage.model.AdminInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperSearchTest {

    @Autowired
    AdminInfoMapper adminInfoMapper;

    @Test
    public void test() {
        AdminInfo adminInfo = adminInfoMapper.selectById(2);
        System.out.println(adminInfo);
    }
}
