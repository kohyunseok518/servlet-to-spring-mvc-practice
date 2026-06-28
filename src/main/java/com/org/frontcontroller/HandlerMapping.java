//package com.org.frontcontroller;
//
//import com.org.controller.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class HandlerMapping {
//    private Map<String, Controller> controllerMap = new HashMap<>();
//
//    public HandlerMapping() {
//        controllerMap.put("GET /mvc/members/new", new MemberFormController());
//        controllerMap.put("GET /mvc/members", new MemberListController());
//        controllerMap.put("POST /mvc/members", new MemberSaveController());
//    }
//
//    public Controller getController(String key) {
//        return controllerMap.get(key);
//    }
//}
