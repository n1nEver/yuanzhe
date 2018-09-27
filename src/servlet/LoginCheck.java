package servlet;

import dao.ApplyDao;
import dao.CmpDao;
import dao.InvitationDao;
import dao.UserDao;
import msg.Apply;
import msg.Invitation;
import users.Cmp;
import users.User;
import users.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginCheck")
public class LoginCheck extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getSession().setAttribute("msg", null);
        request.getSession().setAttribute("thisUser", null);
        request.getSession().setAttribute("thisCmp", null);


        //验证码
        String checkcode = (String) request.getSession().getAttribute("checkCode");


        //获取登录的用户类型
        int type = Integer.parseInt(request.getParameter("loginType"));
        ResultSet resultSet = null;
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");


        //空表单
        if(username.equals("")){
            request.getSession().setAttribute("msg", "请输入您的账号！");
            response.sendRedirect("login.jsp");
            return;
        }

        //验证码错误
        if (!checkcode.equalsIgnoreCase(request.getParameter("checkcode"))) {
            request.getSession().setAttribute("msg", "验证码错误，请重新登陆！");
            response.sendRedirect("login.jsp");
            return;
        }

        //个人用户登陆
        if (type == 1) {
            UserDao userDao = new UserDao();
            User user = userDao.queryByloginName(username);
            if(this.check(user,passwd,"thisUser",request,response)){
                InvitationDao invitationDao = new InvitationDao();
                List<Invitation> invitationList = invitationDao.querryByUserid(user.getId());
                request.getSession().setAttribute("invitationList",invitationList);
                response.sendRedirect("index.jsp");
            }
        }

        //企业用户登陆
        else if (type == 0) {
            CmpDao cmpDao = new CmpDao();
            Cmp cmp = cmpDao.queryByloginName(username);
            if(this.check(cmp,passwd,"thisCmp",request,response)){
                ApplyDao applyDao = new ApplyDao();
                List<Apply> applyList = applyDao.querryByCmpid(cmp.getId());
                request.getSession().setAttribute("applyList",applyList);
                response.sendRedirect("index.jsp");
            }


        }

        //类型错误
        else {
            System.out.println("信息错误。");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    //检查及跳转
    private static boolean  check(Users user, String  passwd ,String thisUser,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(user == null || !user.getPasswd().equals(passwd)){
            request.getSession().setAttribute("msg", "账号或密码错误，请重新登录。");
            response.sendRedirect("login.jsp");
            return false;
        }
        else {
            request.getSession().setAttribute(thisUser, user);
            return true;
        }
    }
}
