<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>调度日志列表</title>
    <link href="/static/css/mine.css" type="text/css" rel="stylesheet"/>
    <link href="/static/pagination/pagination.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="div_head">
            <span>
                <span style="float: left;">当前位置是：包裹管理 => 包裹列表</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                </span>
            </span>
</div>
<div></div>
<div class="div_search">
            <span>
                <form id="_form" action="/package/list" method="post">
                    商户编号：<input type="text" name="umId" value="${umId}" style="width: 100px;"/>
                    收件人手机号：<input type="text" name="receiverPhone" value="${receiverPhone}" style="width: 100px;"/>
                    状态：
                    <select name="pbStatus">
                            <option value="">全部</option>
                            <option value="">支付</option>
                            <option value="">提现</option>
                    </select>
                    </select>
                    录入时间：<input type="text" name="beginTime" value="${beginTime}"
                                onClick="WdatePicker({minDate:'%y-%M-{%d-60}',maxDate:'%y-%M-{%d}'})"
                                style="width: 100px;"/>&nbsp;至
                    <input type="text" name="endTime" value="${endTime}"
                           onClick="WdatePicker({minDate:'%y-%M-{%d-60}',maxDate:'%y-%M-{%d}'})" style="width: 100px;"/>
                    <input value="查询" type="submit"/>
                    <input type="hidden" id="_pageNo" name="pageNo">
                </form>
            </span>
</div>
<div style="font-size: 13px; margin: 10px 5px;">
    <table class="table_a" border="1" width="100%">
        <tbody>
        <tr style="font-weight: bold;">
            <td>包裹编号</td>
            <td>商户编号</td>
            <td>收件人手机号</td>
            <td>领取码</td>
            <td>状态</td>
            <td>录入时间</td>
            <td>支付时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pbEOLt}" var="pbEO" varStatus="index">
            <tr>
                <td><c:out value="${pbEO.pbId}"/></td>
                <td><c:out value="${pbEO.pbUmId}"/></td>
                <td><c:out value="${pbEO.pbReceiverPhone}"/></td>
                <td><c:out value="${pbEO.pbGetCode}"/></td>
                <td><c:out value="${pbEO.pbStatus}"/></td>
                <td><fmt:formatDate value="${pbEO.pbBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${pbEO.pbPayTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <a href="/package/view?pbId=${pbEO.pbId}">查看</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="20" style="text-align: center;">
                <div id="page" class="m-pagination" align="center"></div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="/static/lib/jquery.min.js"></script>
<script type="text/javascript" src="/static/pagination/pagination.js"></script>
<script type="text/javascript" src="/static/dp97/WdatePicker.js"></script>
<script type="text/javascript" src="/static/layer/layer.js"></script>
<script type="text/javascript">
    //分页显示
    $("#page").pagination({
        pageIndex: ${pageNo - 1},
        pageSize: ${pageSize},
        total: ${totalCount},
        pageBtnCount: 11,
        showInfo: true,
        infoFormat: '共{total}条',
        noInfoText: '查询结果为空'
    }).on("pageClicked", function (event, data) {
        $("#_pageNo").val(data.pageIndex + 1);
        $("#_form").submit();
    });
    //
    $("a[href='#']").on('click', function (event) {
        layer.open({
            type: 1,
            area: ['90%', '90%'], //宽高
            //shift: 4,
            maxmin: true,
            scrollbar: false,
            shadeClose: true,     //开启遮罩关闭
            content: $(this).attr("data-msg")
        });
    });
</script>
</body>
</html>