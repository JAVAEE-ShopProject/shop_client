package com.igeek.shop.test;

import com.google.gson.Gson;
import com.igeek.shop.pojo.User;
import com.igeek.shop.utils.MailUtils;
import com.igeek.shop.utils.WebUtils;
import org.junit.Test;

import javax.mail.MessagingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/25 10:23
 * @description：
 * @version: 1.0
 */
public class WebUtilsTest {

    @Test
    public void randomStr() {

        System.out.println(WebUtils.randomStr());
    }
    @Test
    public void sendMail(){
        try {
            MailUtils.sendMail("bcc1725863654@outlook.com","邮箱激活账号","haha");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJson(){

        String str ="123-12-33";
        String[] split = str.split("-");
        System.out.println(Arrays.asList(split));

    }
}