<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
    <link href="../../css/StudentStyle.css" rel="stylesheet" type="text/css" />
    <link href="../../css/ks.css" rel="stylesheet" type="text/css" />
    <link href="../../css/mine.css" type="text/css" rel="stylesheet">
    
    
</head>
<body>
<c:set var="user" value="${data.usersList[0]}" />
		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：权限管理-》人员管理-》详情</span>
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
        <td width="120px">用户名：<span style="color:red">*</span>：</td>
        <td>
            <input id="loginName" type="text"  name="loginName" value="${user.loginName}" onblur="checkLoginName()"/>
            <p id="loginNameErr" style="color:red;display:none;">用户名重复!</p>
        </td>
    </tr>

    <tr  width="120px;">
        <td>密码：<span style="color:red">*</span>：</td>
        <td>
            <input id="password" type="password"  name="password" value="${user.password}" />
        </td>
    </tr>

    <tr  width="120px;">
        <td>姓名<span style="color:red">*</span>：</td>
        <td>
            <input id="realName" type="text"  name="realName" value="${user.realName}" />
        </td>
    </tr>
    <tr>
        <td>性别<span style="color:red">*</span>：</td>
        <td>
            <input id="sex" type="radio" name="sex" ${user.sex==1?"checked":""} value="1" />男 <input ${user.sex==0?"checked":""} type="radio" name="sex" value="0"/>女
        </td>
    </tr>

    <tr>
        <td>角色：<span style="color:red">*</span>：</td>
        <td>
            <select name="roleName">
                <option>--请选择--</option>
                <c:forEach  items="${data.roleList}" var="roles">
                    <option ${user.roleId==roles.roleId?"selected":""}>${roles.roleName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>

    <tr>
        <td>EMAIL：</td>
        <td>
            <input id="email" type="text" name="email" value="${user.email}" onblur="checkEmail()"/>
            <p id="emailErr" style="color:red;display:none;">邮箱重复!</p>
        </td>
    </tr>

    <tr>
        <td>联系电话：</td>
        <td>
            <input id="phone" type="text" name="phone" value="${user.phone}" onblur="checkPhone()" />
            <p id="phoneErr" style="color:red;display:none;">联系电话重复!</p>
        </td>
    </tr>

    <tr>
        <td>住址：</td>
        <td>
            <input type="text" name="address" value="${user.address}" />
        </td>
    </tr>

    <tr>
        <td>身份证号：</td>
        <td>
            <input id="cardId" type="text" name="cardId" value="${user.cardId}" onblur="checkCardId()" />
            <p id="cardIdErr" style="color:red;display:none;">身份证号重复!</p>
        </td>
    </tr>


    <tr>
        <td>简介<span style="color:red">*</span>：</td>
        <td>
            <textarea name="desc">${user.desc}</textarea>
        </td>
    </tr>
				
			</table>
	</form>
</div>

            </div>
        </div>
        
    </div>
</body>
</html>
