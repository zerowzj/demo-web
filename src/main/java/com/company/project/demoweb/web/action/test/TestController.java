package com.company.project.demoweb.web.action.test;

import com.company.project.demoweb.support.web.annotation.Api;
import com.company.project.demoweb.support.web.annotation.PostMapping;

import java.util.Map;

@Api
public class TestController {

    @PostMapping("/demo1")
    public Map<String, Object> demo() {
        System.out.println("aaaaaaaaaaaaa");

        return null;
    }

    @PostMapping("/aaaa")
    public Map<String, Object> demoaaa() {
        System.out.println("bbbbbbbbbbb");

        return null;
    }
}