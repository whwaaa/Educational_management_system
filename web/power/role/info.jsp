<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
    学生信息管理平台
</title>
    <link href="../../css/StudentStyle.css" rel="stylesheet" type="text/css" />
    <link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
    <link href="../../css/ks.css" rel="stylesheet" type="text/css" />
    <link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>


</head>

<body>
<c:set var="role" value="${data.roleList[0]}" />
<div class="div_head">
            <span>
                <span style="float:left">当前位置是：权限管理-》角色管理-》详情</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
</div>
</div>
<div class="cztable">
    <form action="list.html" method="post">
        <table border="1" width="100%" class="table_a">
            <tr  width="120px;">
                <td width="120px">角色名：<span style="color:red">*</span>：</td>
                <td>
                    <input type="text"  name="f_goods_image" value="${role.roleName}" />
                </td>
            </tr>

            <tr  width="120px;">
                <td>菜单资源<span style="color:red">*</span>：</td>
                <td>
                    <ul>
                        <c:forEach var="menu" items="${data.menuList}">
                            <c:if test="${menu.upMenuId==0}">
                                <li><input type="checkbox" name="${menu.menuId}" ${menu.use==true?"checked":""} />${menu.menuName}
                                    <c:forEach var="zmenu" items="${data.menuList}">
                                        <c:if test="${zmenu.upMenuId==menu.menuId}">
                                            <ul>
                                                <li>&nbsp;&nbsp;&nbsp;&nbsp;<input ${zmenu.use==true?"checked":""} type="checkbox" name="${zmenu.menuId}"  />${zmenu.menuName}</li>
                                            </ul>
                                        </c:if>
                                    </c:forEach>
                                </li>
                            </c:if>
                        </c:forEach>

                    </ul>
                </td>
            </tr>

            <tr>
                <td>启用状态<span style="color:red">*</span>：</td>
                <td>
                    <input type="radio" name="roleState" ${role.roleState==1?"checked":""} value="1" />启用 <input ${role.roleState==0?"checked":""} type="radio" name="roleState" value="0"/>禁用
                </td>
            </tr>


        </table>
    </form>
</div>
</body>
</html>
