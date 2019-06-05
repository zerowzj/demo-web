package com.company.project.demoweb.web.action.demo2;

import com.company.project.demoweb.support.context.RequestContext;
import com.company.project.demoweb.support.web.action.BaseAction;
import com.company.project.demoweb.support.web.annotation.Action;

import java.util.Map;

@Action
public class Action_test1 extends BaseAction {

    @Override
    public void checkData(RequestContext ctx) {

    }

    @Override
    public Map<String, Object> processBusiness(RequestContext ctx) {
        return null;
    }
}
