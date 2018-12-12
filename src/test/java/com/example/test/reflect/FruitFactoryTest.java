package com.example.test.reflect;


import com.example.test.reflect.interf.Fruit;
import com.example.test.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FruitFactoryTest {

    @Test
    public void getInstance() {
        Fruit fruit = FruitFactory.getInstance("com.example.test.reflect.interfimpl.Watermelon");
        fruit.eat();
    }


    @Test
    public void getAppleFromJar() throws Exception {
        /*动态加载指定类*/
//        File file=new File("F:/Projects/Test/jar/watermelon.jar");//类路径(包文件上一层)
//        URL url=file.toURI().toURL();
//        ClassLoader loader=new URLClassLoader(new URL[]{url});//创建类加载器
//        //import com.sun.org.apache.bcel.internal.util.ClassLoader;
//        //ClassLoader classLoader = new ClassLoader(new String[]{""});//类路径
//        Class<?> cls=loader.loadClass("com.example.test.reflect.interfimpl.Watermelon");//加载指定类，注意一定要带上类的包名
//        Fruit obj= (Fruit) cls.newInstance();//初始化一个实例
//        obj.eat();
//        Method method =cls.getMethod("eat");
//        method.invoke(obj);

        Fruit fruit = (Fruit) FileUtil.loadObjectFromJar("F:/Projects/Test/jar/watermelon.jar","com.example.test.reflect.interfimpl.Watermelon");
        fruit.eat();
    }
}