<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String baseUrl = request.getContextPath();
    %>
    <title></title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <link href="<%=baseUrl%>/static/css/mine.css" type="text/css" rel="stylesheet">
    <link href="<%=baseUrl%>/static/jqueryui/jquery-ui.min.css" rel="stylesheet">
</head>
<body>
<div class="div_head">
            <span>
                <span style="float:left">当前位置是：包裹管理 => 包裹列表 => 查看</span>
            </span>
</div>
<div></div>
<div style="font-size: 13px;margin: 10px 5px">
    <table border="1" width="100%" class="table_a">
        <tr>
            <td style="width:15%">包裹编号</td>
            <td><c:out value="${pbEO.pbId}" default="-"/></td>
            <td style="width:18%">用户编号</td>
            <td><c:out value="${archive.abEO.abUserId}" default="-"/></td>
        </tr>
        <tr>
            <td>行业大类</td>
            <td><c:out value="${archive.abEO.abIndustryType}" default="-"/></td>
            <td>行业小类</td>
            <td><c:out value="${archive.abEO.abIndustrySubType}" default="-"/></td>
        </tr>
        <tr>
            <td>商户类别名</td>
            <td><c:out value="${archive.abEO.abMerchantClassName}" default="-"/></td>
            <td>商户类型</td>
            <td><c:out value="${archive.abEO.abMerchantType}" default="-"/></td>
        </tr>
        <tr>
            <td>商户名称</td>
            <td><c:out value="${archive.abEO.abMerchantName}" default="-"/></td>
            <td>商户简称</td>
            <td><c:out value="${archive.abEO.abMerchantShortName}" default="-"/></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>营业执照注册号</td>
            <td><c:out value="${archive.abEO.abBusinessLicenseNo}" default="-"/></td>
        </tr>
        <tr>
            <td>工商注册地址</td>
            <td><c:out value="${archive.abEO.abBusinessRegistrationAddress}" default="-"/></td>
            <td>组织机构代码</td>
            <td><c:out value="${archive.abEO.abOrganizationCode}" default="-"/></td>
        </tr>
        <tr>
            <td>税务登记证</td>
            <td><c:out value="${archive.abEO.abTaxRegistration}" default="-"/></td>
            <td>银行开户许可证</td>
            <td><c:out value="${archive.abEO.abBankAccountLicence}" default="-"/></td>
        </tr>
        <tr>
            <td>经营范围</td>
            <td><c:out value="${archive.abEO.abBusinessScope}" default="-"/></td>
            <td>经营地址</td>
            <td><c:out value="${archive.abEO.abBusinessAddress}" default="-"/></td>
        </tr>
        <tr>
            <td>法人姓名</td>
            <td><c:out value="${archive.abEO.abLegalPersonName}" default="-"/></td>
            <td>法人身份证件号码</td>
            <td><c:out value="${archive.abEO.abLegalPersonIdNo}" default="-"/></td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td><c:out value="${archive.abEO.abContactPhone}" default="-"/></td>
            <td>联系人邮箱</td>
            <td><c:out value="${archive.abEO.abContactEmail}" default="-"/></td>
        </tr>
        <tr>
            <td>省份</td>
            <td><c:out value="${archive.abEO.abProvince}" default="-"/></td>
            <td>城市</td>
            <td><c:out value="${archive.abEO.abCity}" default="-"/></td>
        </tr>
        <tr>
            <td>公司名称（签购单）</td>
            <td><c:out value="${archive.abEO.abCompanyName}" default="-"/></td>
            <td>公司经营类型（签购单）</td>
            <td><c:out value="${archive.abEO.abCompanyBusinessType}" default="-"/></td>
        </tr>
        <tr>
            <td>场所面积（平米）</td>
            <td><c:out value="${archive.abEO.abCompanyPlaceArea}" default="-"/></td>
            <td>MCC</td>
            <td><c:out value="${archive.abEO.abMerchantMcc}" default="-"/></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <input type="button" value="返回" onclick="javascript:history.go(-1)">
            </td>
        </tr>
    </table>
</div>
</body>
</html>