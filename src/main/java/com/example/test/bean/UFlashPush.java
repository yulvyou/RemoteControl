package com.example.test.bean;


import lombok.Data;

@Data
public class UFlashPush {
    private long pushId ;
    private Long schId  ;
    private Long userId ;
    private String userType ;
    private String cardNo;
    private String mobile;
    private int eventType;
    private Long machId ;
    private String eventTime ;
    private String receiveTime ;


}
