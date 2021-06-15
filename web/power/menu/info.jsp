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
    <script src="../../js/jquery-1.11.0.js"></script>
    <c:set var="menu" value="${data.menuList[0]}" />

    <script>

    </script>

</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：权限管理-》菜单-》详情</span>
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
                    <td width="120px">资源菜单名：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="menuName" value="${menu.menuName}" />
					</td>
                </tr>

				<tr  width="120px;">
                    <td>上级菜单：<span style="color:red">*</span>：</td>
                    <td>
                    	<select>
                            <c:forEach var="upmenu" items="${menu.upMenuList}">
                                <option ${menu.upMenuId==upmenu.menuId?"selected":""} value="${upmenu.menuId}">${upmenu.menuName}</option>
                            </c:forEach>
                            
                        </select>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>菜单路径<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="url" value="${menu.url}" />
					</td>
                </tr>
                
                <tr>
                    <td>启用状态<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="state" ${menu.state==1?"checked":""} value="1" />启用 <input ${menu.state==0?"checked":""} type="radio" name="state" value="0"/>禁用
                    </td>
                </tr>

				
                <tr  width="120px;">
                    <td>备注<span style="color:red">*</span>：</td>
                    <td>
						<textarea rows="5" cols="20">${menu.desc}</textarea>
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
