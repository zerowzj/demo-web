package com.company.project.adminweb.web.controller.merchant;

import com.company.project.adminweb.common.Preparams;
import com.company.project.dao.usermerchant.UserMerchantEO;
import com.company.project.service.merchant.MerchantService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 商户控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/merchantX")
public class MerchantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    private MerchantService merchantService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        //参数
        Long umId = Preparams.checkToLong("umId");
        String ubLoginName = Preparams.check("ubLoginName");
        Date beginTime = Preparams.checkToDate("beginTime");
        Date endTime = Preparams.checkToDate("endTime");
        Integer pageNo = Preparams.checkToInt("pageNo", 0);
        //查询
        PageList<UserMerchantEO> umEOLt = merchantService.getMerchantPageLt(ubLoginName, umId, beginTime, endTime, pageNo, 5);
        //结果
        Map<String, Object> model = Maps.newHashMap();
        model.put("umEOLt", umEOLt);
        model.put("pageSize", umEOLt.getPaginator().getLimit());
        model.put("pageNo", umEOLt.getPaginator().getPage());
        model.put("totalCount", umEOLt.getPaginator().getTotalCount());
        return new ModelAndView("merchant/merchantLt", model);
    }

    @RequestMapping("/to_modify")
    public ModelAndView to_modify(HttpServletRequest request, HttpServletResponse response) {
        //参数
        Long umId = Preparams.checkToLong("umId");
        //结果
        return new ModelAndView("merchant/merchantModify");
    }

    @RequestMapping("/modify")
    public ModelAndView modify(HttpServletRequest request, HttpServletResponse response) {
        //参数
        Long umId = Preparams.checkToLong("umId");
        //结果
        return new ModelAndView("merchant/merchantModify");
    }
}
