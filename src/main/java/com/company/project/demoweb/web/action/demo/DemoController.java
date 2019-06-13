package com.company.project.demoweb.web.action.demo;

import com.company.project.demoweb.support.web.annotation.Api;

import java.util.Map;

@Api
public class DemoController {

    public DemoController(){
        System.out.println("adsfasdfasdfasdfasdfsadf");
    }

    public Map<String, Object> demo1() {
        System.out.println("aaaaaaaaaaaaa");

        return null;
    }

    public Map<String, Object> demo2() {
        System.out.println("bbbbbbbbbbb");

        return null;
    }
}
