package com.xiaojumao.web;

import com.xiaojumao.bean.Data;
import com.xiaojumao.service.MenuService;
import com.xiaojumao.service.imp.MenuServiceImp;

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
 * @Date Created in 2021-06-15 14:14
 * @Modified By:
 */
@WebServlet(urlPatterns = {"/power/menu/MenuList",
        "/power/menu/Query",
        "/power/menu/Save",
        "/power/menu/Delete"})
public class MenuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().endsWith("MenuList")){
            menuList(req, resp);
        }else if(req.getRequestURI().endsWith("Query")){
            query(req, resp);
        }else if(req.getRequestURI().endsWith("Save")){
            save(req, resp);
        }else if(req.getRequestURI().endsWith("Delete")){
            delete(req, resp);
        }
    }

    /**
     * 查询menu清单
     */
    protected void menuList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页信息
        String pageIndex = req.getParameter("pageIndex");
        // 2.调用Service层方法
        MenuService menuService = new MenuServiceImp();
        Data data = menuService.getMenuListData(pageIndex);
        // 3.跳转
        req.setAttribute("data", data);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    /**
     * 查询详细信息
     */
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页信息
        String pageIndex = req.getParameter("pageIndex");
        String menuId = req.getParameter("menuId");
        String url = req.getParameter("url");
        // 2.调用Service层方法
        MenuService menuService = new MenuServiceImp();
        Data data = menuService.query(pageIndex, menuId);
        // 3.跳转
        req.setAttribute("data", data);
        req.getRequestDispatcher(url).forward(req, resp);
    }


    /**
     * 保存信息
     */
    protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页信息
        String pageIndex = req.getParameter("pageIndex");
        String menuName = req.getParameter("menuName");
        String menuId = req.getParameter("menuId");
        String upMenuId = req.getParameter("upMenuId");
        String url = req.getParameter("url");
        String state = req.getParameter("state");
        String desc = req.getParameter("desc");

        // 2.调用Service层方法
        MenuService menuService = new MenuServiceImp();
        Data data = menuService.save(pageIndex, menuName, menuId, url, state, desc, upMenuId);
        // 3.跳转
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<script>alert(\"操作成功\");window.location.href='/power/menu/MenuList?pageIndex=" + data.getPageInfo().getPageIndex() + "';</script>");
    }

    /**
     * 查询详细信息
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页信息
        String pageIndex = req.getParameter("pageIndex");
        String menuIds = req.getParameter("menuIds");
        // 2.调用Service层方法
        MenuService menuService = new MenuServiceImp();
        Data data = menuService.delete(pageIndex, menuIds);
        // 3.跳转
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<script>alert(\"操作成功\");window.location.href='/power/menu/MenuList?pageIndex=" + data.getPageInfo().getPageIndex() + "';</script>");
    }

}















