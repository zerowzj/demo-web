package com.company.project.adminweb.auth.user;

import com.company.project.dao.userbase.UserBaseEO;
import com.company.project.service.user.UserService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * 用户详情服务
 *
 * @author wangzhj
 */
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //用户信息
        UserBaseEO ubEO = userService.getUserByLoginName(username);
        if (ubEO == null) {
            throw new UsernameNotFoundException("用户名/密码错误");
        }
        //用户详情
        CustomUserDetails userDetails = new CustomUserDetails(username, ubEO.getUbLoginPwd());

        List<SimpleGrantedAuthority> lt = Lists.newArrayList();
        lt.add(new SimpleGrantedAuthority("/function/list"));
        userDetails.setGrantedAuthLt(lt);

        //返回
        return userDetails;
    }
}
