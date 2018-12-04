package com.example.test.reflect;

import com.example.test.reflect.interf.Fruit;

/**
 *
 */
public class FruitFactory {

    public static Fruit getInstance(String className ){
        Fruit fruit = null;

        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  fruit;
    }



}
