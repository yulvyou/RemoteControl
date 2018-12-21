package com.example.jar2exe;

import com.example.jar2exe.utils.ProgramUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class Jar2exeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Jar2exeApplication.class, args);
//        try {
//            ProgramUtils.startProgram("C:/Users/Administrator/AppData/Local/GitBook_Editor/app-7.0.12/Editor.exe");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}

