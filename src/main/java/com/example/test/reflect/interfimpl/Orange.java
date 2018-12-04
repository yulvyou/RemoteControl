package com.example.test.reflect.interfimpl;

import com.example.test.reflect.interf.Fruit;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class Orange implements Fruit {

    @Override
    public void eat() {
        log.info("=========吃橘子=========");
    }
}
