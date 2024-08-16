package com.rycode.cottage;

import com.rycode.cottage.mapper.AdminInfoMapper;
import com.rycode.cottage.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 软删除单元测试
 */
@SpringBootTest
public class MapperSoftDeleteTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
//        String passwordHash = MD5Util.encrypt("1" + "X9xK5DC7iU");
//        String passwordHash = "9b2e403e25a85f7cd86af51350473c98";
//        Map<String,Object> map = new HashMap();
//        map.put("name","zry");
//        map.put("password",passwordHash);
//        List<AdminInfo> adminInfos = adminInfoMapper.selectByMap(map);
//        System.out.println(adminInfos);
        int code = userMapper.deleteById(6666);
        System.out.println(code);
    }
}
