package com.company.project.adminweb.web.controller.user;

import com.company.project.adminweb.common.Preparams;
import com.company.project.service.user.UserService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 包裹控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/to_modify_pwd")
    public ModelAndView to_modify_pwd(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("user/pwdModify");
    }

    @RequestMapping("/modify_pwd")
    public ModelAndView modify_pwd(HttpServletRequest request, HttpServletResponse response) {
        String oldPwd = Preparams.checkNotNullOrEmpty("oldPwd");
        String newPwd = Preparams.checkNotNullOrEmpty("newPwd");
        userService.modifyPwd(null, oldPwd, newPwd);

        return new ModelAndView("pkg/packageLt");
    }
}
