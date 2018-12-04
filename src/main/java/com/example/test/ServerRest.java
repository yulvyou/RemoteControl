//package com.example.test;
//
//import com.example.test.bean.Command;
//import com.example.test.intface.ExecuteCommand;
//import net.sf.json.JSONArray;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// *
// */
//@RestController
//@RequestMapping(value = "/server")
//public class ServerRest {
//
//    @Autowired
//    private CommandDao commandsDao;
//
//    @RequestMapping(value = "/searchCommonds", method = {RequestMethod.GET,RequestMethod.POST})
//    public Map searchCommonds(HttpServletRequest request, HttpServletResponse response, String SchoolId) {
//        Map result = new HashMap();
//        result.put("code", 0);
//        result.put("command", new JSONArray());
//
//        Command command = commandsDao.findOneBySchoolId(SchoolId);
//        if (command == null){
//            result.put("code", 2);
//            return result;
//        }
//
//        Map obj = new HashMap();
//        obj.put("common", command.getCommon());
//        obj.put("url", command.getUrl());
//        obj.put("appName",command.getAppName());
//        obj.put("appPath",command.getAppPath());
//        obj.put("commandId",command.getID());
//        result.put("command", obj);
//
//        return result;
//    }
//
//    @RequestMapping(value = "/updateCommands", method = {RequestMethod.GET,RequestMethod.POST})
//    public void updateCommands(HttpServletRequest request, HttpServletResponse response, String CommandId,String SchooId) {
//        commandsDao.updateByCommandIdAndSchoolId(CommandId,SchooId);
//    }
//
//}
