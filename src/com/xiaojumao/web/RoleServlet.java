package com.xiaojumao.web;

import com.xiaojumao.bean.Data;
import com.xiaojumao.service.RoleService;
import com.xiaojumao.service.imp.RoleServiceImp;

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
 * @Date Created in 2021-06-15 8:10
 * @Modified By:
 */
@WebServlet(urlPatterns = {"/power/role/RoleList",
        "/power/role/Query",
        "/power/role/Save",
        "/power/role/Delete"
})
public class RoleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().endsWith("RoleList")){
            roleList(req, resp);
        }else if(req.getRequestURI().endsWith("Query")){
            query(req, resp);
        }else if(req.getRequestURI().endsWith("Save")){
            save(req, resp);
        }else if(req.getRequestURI().endsWith("Delete")){
            delete(req, resp);
        }

    }

    /**
     * 获取role列表信息
     */
    protected void roleList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页信息
        String pageIndex = req.getParameter("pageIndex");
        // 2.调取service方法
        RoleService roleServiceImp = new RoleServiceImp();
        Data data = roleServiceImp.RoleListData(pageIndex);
        // 3.跳转页面
        req.setAttribute("data", data);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    /**
     * 获取role详细信息
     */
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页信息
        String pageIndex = req.getParameter("pageIndex");
        String url = req.getParameter("url");
        String roleId = req.getParameter("roleId");
        // 2.调取service方法
        RoleService roleServiceImp = new RoleServiceImp();
        Data data = roleServiceImp.RoleInofData(roleId, pageIndex);
        // 3.跳转页面
        req.setAttribute("data", data);
        req.getRequestDispatcher(url).forward(req, resp);
    }

    /**
     * 获取role详细信息
     */
    protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String pageIndex = req.getParameter("pageIndex");
        String roleId = req.getParameter("roleId");
        String menuIds = req.getParameter("menuIds");
        String roleName = req.getParameter("roleName");
        String roleState = req.getParameter("roleState");
        // 2.调取service方法
        RoleService roleServiceImp = new RoleServiceImp();
        Data data = roleServiceImp.save(roleId, menuIds, roleName, roleState, pageIndex);
        // 3.跳转页面
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<script>window.location.href='/power/role/RoleList?pageIndex=" + data.getPageInfo().getPageIndex() + "';</script>");
    }

    /**
     * 删除role
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String pageIndex = req.getParameter("pageIndex");
        String roleId = req.getParameter("roleId");
        // 2.调取service方法
        RoleService roleServiceImp = new RoleServiceImp();
        roleServiceImp.deleteByRoleId(roleId);
        // 3.跳转页面
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<script>window.location.href='/power/role/RoleList?pageIndex=" + pageIndex + "';</script>");
    }
}
