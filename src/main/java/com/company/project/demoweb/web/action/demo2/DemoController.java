package com.company.project.demoweb.web.action.demo2;

import com.company.project.demoweb.support.web.annotation.Action;
import com.company.project.demoweb.support.web.annotation.Api;

import java.util.Map;

@Api
public class DemoController {

    @Action("/demo")
    public Map<String, Object> demo() {
        System.out.println("aaaaaaaaaaaaa");

        return null;
    }

    @Action("/aaaa")
    public Map<String, Object> demoaaa() {
        System.out.println("bbbbbbbbbbb");

        return null;
    }
}
