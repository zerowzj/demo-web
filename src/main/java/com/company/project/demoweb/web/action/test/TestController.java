package com.company.project.demoweb.web.action.test;

import com.company.project.demoweb.support.annotation.Api;

import java.util.Map;

@Api
public class TestController {

    public Map<String, Object> test1() {
        System.out.println("aaaaaaaaaaaaa");

        return null;
    }

    public Map<String, Object> test2() {
        System.out.println("bbbbbbbbbbb");

        return null;
    }
}
