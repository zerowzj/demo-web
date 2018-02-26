package com.company.project.adminweb.web.controller.account;

import com.company.project.dao.accounttransferlog.AccountTransferLogEO;
import com.company.project.service.account.AccountBillService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
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
@RequestMapping("/account")
public class AccountBillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountBillController.class);

    @Autowired
    private AccountBillService accountBillService;

    @RequestMapping("/bill_list")
    public ModelAndView list_bill(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> model = Maps.newHashMap();

        String pageNo = request.getParameter("pageNo");
        if (Strings.isNullOrEmpty(pageNo)) {
            pageNo = "1";
        }

        PageList<AccountTransferLogEO> atlEOLt = accountBillService.getBillPageLt(null, Ints.tryParse(pageNo), 10);
        model.put("atlEOLt", atlEOLt);
        model.put("pageNo", atlEOLt.getPaginator().getPage());
        model.put("pageSize", atlEOLt.getPaginator().getLimit());
        model.put("totalCount", atlEOLt.getPaginator().getTotalCount());
        return new ModelAndView("account/accountBillLt", model);
    }
}
