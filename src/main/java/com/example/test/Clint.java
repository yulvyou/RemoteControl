package com.example.test;

import com.example.test.constants.ClintConstant;
import com.example.test.factory.CommandFactory;
import com.example.test.factory.ThreadPoolFactory;
import com.example.test.intface.ExecuteCommand;
import com.example.test.reflect.FruitFactory;
import com.example.test.reflect.interf.Fruit;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 */
@Slf4j
public class Clint {

    @Scheduled(cron = "0 15 10 ? * *")
    public void run() {
        //是否为第一次启动
        if (isFirstLunch()) {
            //设置为开机自启动
            setAutoLunch();
        }

        //向服务端请求本客户端需要执行的命令
        String Command = getCommandsFromServer(ClintConstant.schoolId,ClintConstant.clientNo);

        //执行相关命令
        ThreadPoolFactory.getNormalPool().execute(new Runnable() {
            @Override
            public void run() {
                executeCommand(Command);
            }
        });


    }//run


    /**
     * 判断是否为第一次启动
     *
     * @return
     */
    private Boolean isFirstLunch() {
        return true;
    }

    /**
     * 将本程序设置为开机自启动
     */
    public void setAutoLunch() {

    }




    /**
     * 向服务器请求本客户端需要执行的指令
     *
     * @param schoolId 学校id
     */
    public String getCommandsFromServer(String schoolId,String clientNo) {

        return null;
    }

    /**
     * 执行命令
     * @param Command
     */
    public void executeCommand(String Command) {
        JSONObject commandJson = JSONObject.fromObject(Command);

        ExecuteCommand executeCommand = null;
        //没有需要执行的指令
        if (commandJson.get("code").equals("0")||commandJson.get("code").equals("2")||commandJson == null) {
            return;
        }

        //下载jar包
        boolean jarDownloaded = downloadJar(commandJson);

        //实例化ExecuteCommand对象
        if(jarDownloaded){
            executeCommand = CommandFactory.getInstance((String) commandJson.get("jarPath"));
        }else{
            log.error("");
            return;
        }

        //执行相关操作
        if(executeCommand!=null){
            //下载文件
            executeCommand.downloadFile(commandJson);
            //关闭程序
            executeCommand.closeApp("appName");
            //安装更新包
            executeCommand.installApp(commandJson);
            //打开程序
            executeCommand.openApp(commandJson);
            //执行命令
            executeCommand.execute();
            //通知服务器
            executeCommand.noticeServer("schoolId");
        }else {
            log.error("");
            return;
        }

    }

    /**
     * 下载jar包
     */
    private boolean downloadJar(JSONObject resultJson) {
        //1、根据jarPath判断是否本地是否已经下载了
        //1.1如本地下载了就根据jarHashCode判断jar包是否完整，否则删除原来的重新下载

        //2、根据jarUrl下载jar包到jarPath指定的路径
        //2.1 根据jarHashCode判断jar包是否完整

        return true;
    }


}//END
