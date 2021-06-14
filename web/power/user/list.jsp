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

        function delone(_this){
            if(confirm("确定删除？")){
                window.location.href = "/power/user/Delete?userIds=" + _this.attr("name") + "&pageIndex=${data.pageInfo.pageIndex}";
            }
        }

		function del(){
            checkbox();
            if(url != ""){
                if(confirm("确定删除？")){
                    window.location.href = url;
                }
            }
		}

		var url;
		function checkbox(){
            url = "";
            var canshu = "userIds=";
            $("input[name='checkboxs']").each(function () {
                if($(this).is(':checked')) {
                    canshu += $(this).val()+",";

                }
            })
            if(canshu != "canshu"){
                url = "/power/user/Delete?pageIndex=" + ${data.pageInfo.pageIndex} + "&" + canshu;
            }
            console.log(url);
        }

    </script>

</head>
<body>


<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》人员管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
          
            <a style="text-decoration: none;" href="javascript:void(0);" onclick="del()">【批量删除】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="Add">【新增人员】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>
 <div class="cztable" style="width: 100%;">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px;" align="center">
                    
                    <th  width="8%">

					</th>
					<th scope="col" width="15%">
                        序号
                    </th>
                    <th scope="col" width="15%">
                        账号
                    </th>
                    <th scope="col" width="15%">
                        姓名
                    </th>
                    <th scope="col" width="15%">
                        角色
                    </th>
                   
                    <th scope="col" >
                        操作
                    </th>
                </tr>

               <c:forEach items="${data.usersList}" var="user">
                   <tr align="center">
                       <th><input name="checkboxs" type="checkbox" value="${user.userId}" onclick="checkbox()"/></th>
                       <td>
                           ${user.userId}
                       </td>

                       <td>
                           ${user.loginName}
                       </td>
                       <td>
                           <a href="Info?userId=${user.userId}&pageIndex=${data.pageInfo.pageIndex}">${user.realName}</a>
                       </td>

                       <td>&nbsp;
                           ${user.roleName}
                       </td>

                       <td>&nbsp;
                           <a href="Editor?userId=${user.userId}&pageIndex=${data.pageInfo.pageIndex}">修改</a>
                           <a href="Delete?userId=${user.userId}" name="${user.userId}" onclick="delone($(this));return false" class="tablelink"> 删除</a>
                       </td>
                   </tr>
               </c:forEach>
                

                

            </tbody>
        </table>
        
          <div class='MainStyle'><div class=''>
              <a href="UserList?pageIndex=1" target='_self'>首页</a>
          </div>
          <div class=''>
              <a href="UserList?pageIndex=${data.pageInfo.pageIndex-1==0?1:data.pageInfo.pageIndex-1}" target='_self'>上一页</a>
          </div>

              <c:forEach var="i" begin="1" end="${data.pageInfo.pageTotal}" step="1">
                  <div class='NowItemStyle'>
                      <a href="UserList?pageIndex=${i}" target='_self'>${i}</a>
                  </div>
              </c:forEach>


              <div class=''>
                  <a href="UserList?pageIndex=${data.pageInfo.pageIndex+1>data.pageInfo.pageTotal?data.pageInfo.pageTotal:data.pageInfo.pageIndex+1}" target='_self'>下一页</a>
              </div>
              <div class=''>
                  <a href="UserList?pageIndex=${data.pageInfo.pageTotal}" target='_self'>尾页</a>
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
             if(searchIndex > 0 && searchIndex <= ${data.pageInfo.indexTotal}) {
                 window.location="UserList?pageIndex=" + searchIndex;
             }else{
                 alert('需要跳转的页码不能超出范围！');
             }
         }
     </script>


 </div>
</div>

        
        
      
    </div>
</body>
</html>