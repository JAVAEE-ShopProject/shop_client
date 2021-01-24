package com.igeek.shop.test;

import com.igeek.shop.pojo.User;
import com.igeek.shop.utils.WebUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/24 9:45
 * @description：
 * @version: 1.0
 */
public class BaseDaoTest {

    @Test
    public void update() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","李四");
        map.put("birthDay","1997-10-16");
        map.put("age","18");
        User user = WebUtils.parseMapToBean(new User(), map);
        System.out.println(user);
    }
}