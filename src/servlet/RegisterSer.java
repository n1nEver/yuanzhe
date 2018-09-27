package servlet;

import dao.CmpDao;
import dao.UserDao;
import users.Cmp;
import users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterSer")
public class RegisterSer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getSession().setAttribute("msg",null);
        String type = request.getParameter("type");
        String loginname = request.getParameter("loginname") == null ? "" : request.getParameter("loginname");
        String phonenum = request.getParameter("phonenum") == null ? "" : request.getParameter("phonenum");
        String newpasswd = request.getParameter("newpasswd") == null ? "" : request.getParameter("newpasswd");
        if((loginname.equals("") && phonenum.equals("")) || newpasswd.equals("") ){
            request.getSession().setAttribute("msg","请填写必要信息！");
            response.sendRedirect("register.jsp");
        }
        else if(!request.getParameter("newpasswd").equals(request.getParameter("newpasswd2"))){
            request.getSession().setAttribute("msg","两次密码不同！");
            response.sendRedirect("register.jsp");
        }

        else if (type.equals("1")){
            int done = 0;
            UserDao userDao = new UserDao();

            User user = new User(request.getParameter("name"),
                    request.getParameter("sex"),
                    request.getParameter("email"),
                    request.getParameter("phonenum"),
                    request.getParameter("educated"),
                    request.getParameter("school"),
                    request.getParameter("major"),
                    request.getParameter("newpasswd"),
                    request.getParameter("birth"));
            done = userDao.addUser(user);
            if(done == 1){
                request.getSession().setAttribute("msg","注册成功！");
                response.sendRedirect("login.jsp");
            }
            else{
                request.getSession().setAttribute("msg","注册失败！");
                response.sendRedirect("register.jsp");
            }
        }
        else if(type.equals("0")){
            int done = 0;
            CmpDao cmpDao = new CmpDao();
            Cmp cmp = new Cmp(request.getParameter("fullname"),
                    request.getParameter("loginname"),
                    request.getParameter("newpasswd"),
                    request.getParameter("address"),
                    request.getParameter("mgrname"),
                    request.getParameter("mgrpn"),
                    request.getParameter("industry"));
            done = cmpDao.addCmp(cmp);
            if(done == 1){
                request.getSession().setAttribute("msg","注册成功！");
                response.sendRedirect("login.jsp");
            }
            else {
                request.getSession().setAttribute("msg","注册失败！");
                response.sendRedirect("register.jsp");
            }

        }
        else {
            request.getSession().setAttribute("msg","系统出错！");
            response.sendRedirect("register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
