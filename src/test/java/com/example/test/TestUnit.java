package com.example.test;

import com.example.test.bean.Student;
import com.example.test.bean.UFlashPush;
import com.example.test.bean.UPushData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUnit {


    @Test
    public void map2ObjectTest() {
        try {

            Map map = new HashMap();
            map.put("name", "ttt");
            map.put("score", 80);
            map.put("className", "");
            map.put("hello", "helloWord");

            Student student = new Student();
            BeanUtils.populate(student, map);
            System.out.println(student);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testBeanUtil() {

        try {
            UFlashPush uFlashPush = new UFlashPush();
            UPushData uPushData = new UPushData();
            uPushData.setPushId(2);
            uPushData.setEventType(1);
            uPushData.setHello("hello");
            BeanUtils.copyProperties(uPushData, uFlashPush);
            System.out.println("UFlashPush信息：" + uFlashPush.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * 关闭程序
     */
    public static void shutdownProgram(String programName) {
        String command = "taskkill /f /im " + programName;
        Runtime runtime = Runtime.getRuntime();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(command).getInputStream()));
            //StringBuffer b = new StringBuffer();
            String line=null;
            StringBuffer b=new StringBuffer();
            while ((line=br.readLine())!=null) {
                b.append(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 启动程序，可以是exe程序也可以是bat脚本
     * @param programPath
     * @throws IOException
     */
    public static void startProgram(String programPath) throws IOException {
        if (!StringUtils.isEmpty(programPath)) {
            try {
                String programName = programPath.substring(programPath.lastIndexOf("/") + 1, programPath.lastIndexOf("."));
                List<String> list = new ArrayList<String>();
                list.add("cmd.exe");
                list.add("/c");
                list.add("start");
                list.add("\"" + programName + "\"");
                list.add("\"" + programPath + "\"");
                ProcessBuilder pBuilder = new ProcessBuilder(list);
                pBuilder.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void startProgramTest() throws IOException {
//        String programPath = "D:/360极速浏览器下载/wechat_devtools_1.02.1811150_x64.exe";
        String programPath = "C:/Users/Administrator/Desktop/run.bat";
        startProgram(programPath);
    }


    @Test
    public void shutdownProgramTest() throws IOException {
        shutdownProgram("Editor.exe");
    }
}


