package com.company.project.adminweb.web.controller.pkg;

import com.company.project.adminweb.common.Preparams;
import com.company.project.dao.packagebase.PackageBaseEO;
import com.company.project.service.pkg.PackageService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Maps;
import com.google.common.primitives.Longs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Map;

/**
 * 包裹控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/package")
public class PackageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private PackageService packageService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        //参数
        Long umId = Preparams.checkToLong("umId");
        String receiverPhone = Preparams.check("receiverPhone");
        String pbStatus = Preparams.check("pbStatus");
        Date beginTime = Preparams.checkToDate("beginTime");
        Date endTime = Preparams.checkToDate("endTime");

        Integer pageNo = Preparams.checkToInt("pageNo", 1);
        //查询
        PageList<PackageBaseEO> pbEOLt = packageService.getPackagePageLt(umId, receiverPhone, null, null, pageNo, 2);
        //结果
        Map<String, Object> model = Maps.newHashMap();
        model.put("pbEOLt", pbEOLt);
        model.put("pageSize", pbEOLt.getPaginator().getLimit());
        model.put("pageNo", pbEOLt.getPaginator().getPage());
        model.put("totalCount", pbEOLt.getPaginator().getTotalCount());
        return new ModelAndView("package/packageLt", model);
    }

    @RequestMapping("/view")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
        //参数
        String pbId = Preparams.checkNotNullOrEmpty("pbId");
        //查询
        PackageBaseEO pbEO = packageService.getPackage(Longs.tryParse(pbId));
        //结果
        return new ModelAndView("package/packageView", "pbEO", pbEO);
    }
}
