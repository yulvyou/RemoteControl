package com.example.test.bean;

import lombok.Data;
import lombok.Getter;

import java.io.*;
import java.util.Date;

/**
 *
 */
@Data
public class Student implements Serializable {
    private int score;
    private String className;
    private String name;
    private Date createDate;

    public Student() {
    }

    public Student(int score, String className, String name) {
        // TODO Auto-generated constructor stub
        this.score = score;
        this.className = className;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student [score=" + score + ", className=" + className + ", name=" + name
                + ", createDate=" + createDate + "]";
    }

//    /**
//     * 使用序列化的方式实现深度clone
//     * @return
//     * @throws IOException
//     * @throws ClassNotFoundException
//     */
//    public Student deepClone() throws IOException, ClassNotFoundException{
//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bao);
//        objectOutputStream.writeObject(this);
//
//        ByteArrayInputStream baInput = new ByteArrayInputStream(bao.toByteArray());
//        ObjectInputStream objectInputStream = new ObjectInputStream(baInput);
//        Student stu = (Student)objectInputStream.readObject();
//
//        return stu;
//    }
}