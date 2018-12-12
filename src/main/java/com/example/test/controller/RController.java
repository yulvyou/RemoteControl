package com.example.test.controller;

import com.example.test.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/command")
@Slf4j
public class RController {
    //订单详情
    @GetMapping("/get")
    public String detail(@RequestParam("version") String version) {
        if (Integer.valueOf(version) <= 2){
            return FileUtil.readJsonFromFile("F:\\Projects\\Test\\MethodTest\\src\\main\\resources\\static\\test_resultFromServer"+version+".json");
        }else{
            return FileUtil.readJsonFromFile("F:\\Projects\\Test\\MethodTest\\src\\main\\resources\\static\\test_resultFromServer_null.json");
        }

    }



}
