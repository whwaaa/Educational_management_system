package com.xiaojumao.bean;

import com.xiaojumao.utils.PageInfo;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-14 15:13
 * @Modified By:
 */
public class Data {
    private List<Grade> gradeList;
    private List<Menu> menuList;
    private List<Middle> middleList;
    private List<Role> roleList;
    private List<Student> studentList;
    private List<Users> usersList;
    private PageInfo pageInfo;
    private MySession mySession;

    public MySession getMySession() {
        return mySession;
    }

    public void setMySession(MySession mySession) {
        this.mySession = mySession;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Middle> getMiddleList() {
        return middleList;
    }

    public void setMiddleList(List<Middle> middleList) {
        this.middleList = middleList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Data(List<Grade> gradeList, List<Menu> menuList, List<Middle> middleList, List<Role> roleList, List<Student> studentList, List<Users> usersList, PageInfo pageInfo, MySession mySession) {
        this.gradeList = gradeList;
        this.menuList = menuList;
        this.middleList = middleList;
        this.roleList = roleList;
        this.studentList = studentList;
        this.usersList = usersList;
        this.pageInfo = pageInfo;
        this.mySession = mySession;
    }

    public Data() {
    }
}
