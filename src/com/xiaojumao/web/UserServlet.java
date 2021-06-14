package com.xiaojumao.web;

import com.xiaojumao.bean.Data;
import com.xiaojumao.bean.Users;
import com.xiaojumao.service.UsersService;
import com.xiaojumao.service.imp.UsersServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-22 18:35
 * @Modified By:
 */
@WebServlet(urlPatterns = {"/power/user/UserList",
        "/power/user/Editor",
        "/power/user/CheckLoginName",
        "/power/user/CheckEmail",
        "/power/user/CheckPhone",
        "/power/user/CheckCardId",
        "/power/user/EditSave",
        "/power/user/Info",
        "/power/user/Delete",
        "/power/user/Add",
        "/power/user/AddSave"
})
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().endsWith("UserList")){
            userList(req, resp);
        }else if(req.getRequestURI().endsWith("Editor")){
            editor(req, resp);
        }else if(req.getRequestURI().endsWith("CheckLoginName")){
            checkLoginName(req, resp);
        }else if(req.getRequestURI().endsWith("CheckEmail")){
            checkEmail(req, resp);
        }else if(req.getRequestURI().endsWith("CheckPhone")){
            checkPhone(req, resp);
        }else if(req.getRequestURI().endsWith("CheckCardId")){
            checkCardId(req, resp);
        }else if(req.getRequestURI().endsWith("EditSave")){
            editSave(req, resp);
        }else if(req.getRequestURI().endsWith("Info")){
            info(req, resp);
        }else if(req.getRequestURI().endsWith("Delete")){
            delete(req, resp);
        }else if(req.getRequestURI().endsWith("Add")){
            add(req, resp);
        }else if(req.getRequestURI().endsWith("AddSave")){
            addSave(req, resp);
        }

    }

    /**
     * 获取用户列表
     */
    protected void userList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String pageIndex = req.getParameter("pageIndex");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        Data data = usersServiceImp.getListData(pageIndex);

        // 3.存入数据跳转页面
        req.setAttribute("data", data);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    /**
     * 获取待编辑用户信息
     */
    protected void editor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String userId = req.getParameter("userId");
        String pageIndex = req.getParameter("pageIndex");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        Data data = usersServiceImp.getEditorData(userId, pageIndex);

        // 3.存入数据跳转页面
        req.setAttribute("data", data);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    /**
     * 显示用户详细信息
     */
    protected void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String userId = req.getParameter("userId");
        String pageIndex = req.getParameter("pageIndex");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        Data data = usersServiceImp.getEditorData(userId, pageIndex);

        // 3.存入数据跳转页面
        req.setAttribute("data", data);
        req.getRequestDispatcher("info.jsp").forward(req, resp);
    }

    /**
     * 查询用户名是否重复
     */
    protected void checkLoginName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String loginName = req.getParameter("loginName");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        String res = usersServiceImp.checkLoginName(loginName);
        // 3.ajax传入前端
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8;");
        resp.getWriter().print(res);
    }

    /**
     * 查询邮件是否重复
     */
    protected void checkEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String email = req.getParameter("email");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        String res = usersServiceImp.checkEmail(email);
        // 3.ajax传入前端
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8;");
        resp.getWriter().print(res);
    }

    /**
     * 查询电话是否重复
     */
    protected void checkPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String phone = req.getParameter("phone");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        String res = usersServiceImp.checkPhone(phone);
        // 3.ajax传入前端
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8;");
        resp.getWriter().print(res);
    }

    /**
     * 查询身份证是否重复
     */
    protected void checkCardId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String cardId = req.getParameter("cardId");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        String res = usersServiceImp.checkCardId(cardId);
        // 3.ajax传入前端
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8;");
        resp.getWriter().print(res);
    }

    /**
     * 保存修改信息
     */
    protected void editSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        // 当前页码
        String pageIndex = req.getParameter("pageIndex");
        Users users = new Users();
        users.setRoleName(req.getParameter("roleName"));
        users.setUserId(Integer.parseInt(req.getParameter("userId")));
        users.setDesc(req.getParameter("desc"));
        users.setPassword(req.getParameter("password"));
        users.setLoginName(req.getParameter("loginName"));
        users.setEmail(req.getParameter("email"));
        users.setPhone(req.getParameter("phone"));
        users.setRealName(req.getParameter("realName"));
        users.setSex(Integer.parseInt(req.getParameter("sex")));
        users.setCardId(req.getParameter("cardId"));
        users.setAddress(req.getParameter("address"));
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        usersServiceImp.editSave(users);
        // 3.跳转页面
        resp.setContentType("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<script>window.location.href='/power/user/UserList?pageIndex=" + pageIndex + "';</script>");
    }


    /**
     * 删除数据
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        String userIds = req.getParameter("userIds");
        String pageIndex = req.getParameter("pageIndex");
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        usersServiceImp.delete(userIds);
        // 3.跳转页面
        resp.setContentType("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<script>window.location.href='/power/user/UserList?pageIndex=" + pageIndex + "';</script>");
    }


    /**
     * 添加信息
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用service方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        Data data = usersServiceImp.add();
        // 跳转
        req.setAttribute("data", data);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    /**
     * 保存添加信息
     */
    protected void addSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取数据
        Users users = new Users();
        String roleId = req.getParameter("roleId");
        users.setRoleId(Integer.parseInt(roleId));
        users.setDesc(req.getParameter("desc"));
        users.setPassword(req.getParameter("password"));
        users.setLoginName(req.getParameter("loginName"));
        users.setEmail(req.getParameter("email"));
        users.setPhone(req.getParameter("phone"));
        users.setRealName(req.getParameter("realName"));
        users.setSex(Integer.parseInt(req.getParameter("sex")));
        users.setCardId(req.getParameter("cardId"));
        users.setAddress(req.getParameter("address"));
        // 2.调用service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        Data data = usersServiceImp.addSave(users);
        // 3.跳转页面
        resp.setContentType("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<script>window.location.href='/power/user/UserList?pageIndex=" + data.getPageInfo().getPageTotal() + "';</script>");
    }
}
