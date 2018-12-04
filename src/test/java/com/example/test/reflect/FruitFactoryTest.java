package com.example.test.reflect;

import com.example.test.reflect.interf.Fruit;
import com.example.test.reflect.interfimpl.Apple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FruitFactoryTest {

    @Test
    public void getInstance() {
        Fruit fruit = FruitFactory.getInstance("com.example.test.reflect.interfimpl.Apple");
        fruit.eat();
    }
}