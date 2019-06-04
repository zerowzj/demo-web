package com.company.project.demoweb.web.demo;

import com.company.project.demoweb.support.web.annotation.Action;
import com.company.project.demoweb.support.web.annotation.Api;

import java.util.Map;

@Api
public class DemoController {

    @Action
    public Map<String, Object> demo() {

        return null;
    }
}
