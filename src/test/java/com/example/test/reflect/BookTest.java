package com.example.test.reflect;

import com.example.test.reflect.interfimpl.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookTest {

    @Test
    public void getSetTest(){
        String fieldName = "title"; //需要操作的成员变量
        try {
            Class<?> cls = Class.forName("com.example.test.reflect.interfimpl.Book");
            Object obj = cls.newInstance();  //必须实例化对象
            Method setMet = cls.getMethod("set"+ "Title" , String.class);
            Method getMet = cls.getMethod("get"+ "Title");
            setMet.invoke(obj, "JAVA 反射");
            log.info(getMet.invoke(obj)+"");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
