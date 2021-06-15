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

        function delone(menuIds){
            if(confirm("确定删除？")){
                window.location.href = "/power/menu/Delete?menuIds=" + menuIds + "&pageIndex=${data.pageInfo.pageIndex}";
            }
        }

        var url = "";
        function del(){
            checkbox();
            if(url != ""){
                if(confirm("确定删除？")){
                    window.location.href = url;
                }
            }
        }
        function checkbox(){
            var menuIds = "";
            var flag = true;
            $(".itembox").each(function(){
                if($(this).is(":checked")){
                    menuIds += $(this).val()+",";
                }else{
                    flag = false;
                }
            })
            $(".prefbox").prop("checked",flag);
            url = "/power/menu/Delete?pageIndex=" + ${data.pageInfo.pageIndex} + "&menuIds=" + menuIds;
            console.log(url);
        }

        $(document).ready(function (){
            $(".prefbox").on("click", function(){
                if($(this).is(":checked")){
                    $(".itembox").prop("checked",true);
                }else{
                    $(this).prop("checked",false);
                    $(".itembox").prop("checked",false);
                }
                checkbox();
            })
            $(".itembox").on("click", function(){
                checkbox();
            })
        })

    </script>
</head>
<body>



<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》菜单管理</span> <span
                style="float:right;margin-right: 8px;font-weight: bold">
            <a style="text-decoration: none;" href="javascript:del();">【批量删除】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="Query?url=add.jsp">【新增菜单】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
</div>

<div class="morebt">
 
</div>





 <div class="cztable">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th><input class="prefbox" type="checkbox"/></th>
                    <th scope="col">
                        序号
                    </th>
                    
                    <th scope="col">
                        菜单名称
                    </th>
                    <th scope="col">
                        URL
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col">
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${data.menuList}" var="menu">
                    <tr align="center">
                        <th><input class="itembox" name="checkboxs" type="checkbox" value="${menu.menuId}"/></th>
                        <td>
                                ${menu.menuId}
                        </td>
                        <td>
                                ${menu.menuName}
                        </td>
                        <td>
                            <a href="${menu.url}" target="_blank">${menu.url}</a>
                        </td>

                        <td>&nbsp;
                                ${menu.state==1?"启用":"禁用"}
                        </td>

                        <td>&nbsp;
                            <a href="javascript:alert('操作成功！');"> ${menu.state==0?"启用":"禁用"}</a>
                            <a href="Query?menuId=${menu.menuId}&pageIndex=${data.pageInfo.pageIndex}&url=info.jsp">详情</a>
                            <a href="Query?menuId=${menu.menuId}&pageIndex=${data.pageInfo.pageIndex}&url=edit.jsp">修改</a>
                            <a href="javascript:void(0);" onclick="delone(${menu.menuId});return false"> 删除</a>
                        </td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>

     <div class='MainStyle'><div class=''>
         <a href="MenuList?pageIndex=1" target='_self'>首页</a>
     </div>
         <div class=''>
             <a href="MenuList?pageIndex=${data.pageInfo.pageIndex-1==0?1:data.pageInfo.pageIndex-1}" target='_self'>上一页</a>
         </div>

         <c:forEach var="i" begin="1" end="${data.pageInfo.pageTotal}" step="1">
             <div class='NowItemStyle'>
                 <a href="MenuList?pageIndex=${i}" target='_self'>${i}</a>
             </div>
         </c:forEach>
     <div class=''>
         <a href="MenuList?pageIndex=${data.pageInfo.pageIndex+1>data.pageInfo.pageTotal?data.pageInfo.pageTotal:data.pageInfo.pageIndex+1}" target='_self'>下一页</a>
     </div>
     <div class=''>
         <a href="MenuList?pageIndex=${data.pageInfo.pageTotal}" target='_self'>尾页</a>
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
            window.location="MenuList?pageIndex=" + searchIndex;
        }else{
            alert('需要跳转的页码不能超出范围！');
        }
    }
</script>


</body>
</html>