package com.example.test.factory;

import com.example.test.intface.ExecuteCommand;

/**
 *
 */
public class CommandFactory {
    public static ExecuteCommand getInstance(String className ){
        ExecuteCommand executeCommand = null;

        try {
            executeCommand = (ExecuteCommand) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  executeCommand;
    }
}
