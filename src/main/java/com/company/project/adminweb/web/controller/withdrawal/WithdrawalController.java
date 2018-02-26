package com.company.project.adminweb.web.controller.withdrawal;

import com.company.project.adminweb.common.Preparams;
import com.company.project.dao.accountwithdrawal.AccountWithdrawalEO;
import com.company.project.service.account.WithdrawalService;
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
import java.util.Map;

/**
 * 包裹控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/withdrawal")
public class WithdrawalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawalController.class);

    @Autowired
    private WithdrawalService withdrawalService;

    @RequestMapping("/list")
    public ModelAndView list_bill(HttpServletRequest request, HttpServletResponse response) {
        //参数
        Long ubId = Preparams.checkToLong("ubId");
        Integer pageNo = Preparams.checkToInt("pageNo", 1);
        //查询
        PageList<AccountWithdrawalEO> awEOLt = withdrawalService.getWithdrawalPageLt(ubId, pageNo, 10);
        //结果
        Map model = Maps.newHashMap();
        model.put("awEOLt", awEOLt);
        model.put("pageNo", awEOLt.getPaginator().getPage());
        model.put("pageSize", awEOLt.getPaginator().getLimit());
        model.put("totalCount", awEOLt.getPaginator().getTotalCount());
        return new ModelAndView("withdrawal/withdrawalLt", model);
    }
}
