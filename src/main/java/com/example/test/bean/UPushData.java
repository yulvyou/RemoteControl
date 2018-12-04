package com.example.test.bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;


@Data
public class UPushData implements Serializable,Cloneable {
    private int  pushId;
    //'0 考勤；1 消费'
    private int eventType;


    private String hello;



}
