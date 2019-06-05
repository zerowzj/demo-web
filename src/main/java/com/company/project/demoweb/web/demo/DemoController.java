package com.company.project.demoweb.web.demo;

import com.company.project.demoweb.support.web.annotation.Action;
import com.company.project.demoweb.support.web.annotation.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
