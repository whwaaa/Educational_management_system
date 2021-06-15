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
    <script>
	function del(roleId){
        if(confirm("确定删除？")){
            window.location.href = "/power/role/Delete?roleId=" + roleId + "&pageIndex=${data.pageInfo.pageIndex}";
        }
	}

</script>
</head>
<body>

   

<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》角色管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
			<a style="text-decoration: none;" href="Query?url=add.jsp">【新增角色】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>


 <div class="cztable">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
<%--                	<th><input type="checkbox"/></th>--%>
                    <th scope="col">
                        序号
                    </th>
                    
                    <th scope="col">
                        角色名称
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col" width="300px">
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${data.roleList}" var="role">
                    <tr align="center">
<%--                        <th><input type="checkbox"/></th>--%>
                        <td>
                            ${role.roleId}
                        </td>
                        <td>
                            ${role.roleName}
                        </td>
                        <td>&nbsp;
                            ${role.roleState==1?"启用":"禁用"}
                        </td>

                        <td>&nbsp;
                            <a href="javascript:alert('操作成功！');"> ${role.roleState==0?"启用":"禁用"}</a>
                            <a href="Query?roleId=${role.roleId}&pageIndex=${data.pageInfo.pageIndex}&url=info.jsp">详情</a>
                            <a href="Query?roleId=${role.roleId}&pageIndex=${data.pageInfo.pageIndex}&url=edit.jsp">修改</a>
                            <a href="javascript:void(0);" name="${role.roleId}" onclick="del(${role.roleId});return false"> 删除</a>
                        </td>
                    </tr>
                </c:forEach>

               
                
            </tbody>
        </table>

     <div class='MainStyle'><div class=''>
         <a href="RoleList?pageIndex=1" target='_self'>首页</a>
     </div>
         <div class=''>
             <a href="RoleList?pageIndex=${data.pageInfo.pageIndex-1==0?1:data.pageInfo.pageIndex-1}" target='_self'>上一页</a>
         </div>

         <c:forEach var="i" begin="1" end="${data.pageInfo.pageTotal}" step="1">
             <div class='NowItemStyle'>
                 <a href="RoleList?pageIndex=${i}" target='_self'>${i}</a>
             </div>
         </c:forEach>


         <div class=''>
             <a href="RoleList?pageIndex=${data.pageInfo.pageIndex+1>data.pageInfo.pageTotal?data.pageInfo.pageTotal:data.pageInfo.pageIndex+1}" target='_self'>下一页</a>
         </div>
         <div class=''>
             <a href="RoleList?pageIndex=${data.pageInfo.pageTotal}" target='_self'>尾页</a>
         </div>
         <div class=''>总共<b>${data.pageInfo.indexTotal}</b>条数据</div><div class=''>每页<b>${data.pageInfo.pageSize}</b>条数据</div><div class=''><b>${data.pageInfo.pageIndex}</b>/${data.pageInfo.pageTotal}</div>
         <div class='SearchStyle'>
             <input type='text' id='john_Page_Search' onkeydown="if(event.keyCode == 13){page_searchIndex();}"/>
         </div>
         <div class=''>
             <input type='button' value='Go' onclick="page_searchIndex()"/>
         </div>
     </div>
     <script>
         function page_searchIndex() {
             var searchText = document.getElementById('john_Page_Search');
             var searchIndex = searchText != null && searchText.value != '' ? parseInt(searchText.value) : 0;
             if(searchIndex > 0 && searchIndex <= ${data.pageInfo.pageTotal}) {
                 window.location="RoleList?pageIndex=" + searchIndex;
             }else{
                 alert('需要跳转的页码不能超出范围！');
             }
         }
     </script>

 </div>

</body>
</html>