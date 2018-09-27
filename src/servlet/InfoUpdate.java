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

@WebServlet(name = "InfoUpdate")
public class InfoUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");


        request.getSession().setAttribute("msg",null);

        String type = request.getParameter("type");


        //用户基本信息修改
        if(type.equals("1")){
            UserDao userDao = new UserDao();
            int done = 0;
            User oldUser = (User) request.getSession().getAttribute("thisUser");
            User user = oldUser.clone();
            user.setName(request.getParameter("name"));
            user.setBirth(request.getParameter("birth"));
            user.setEducated(request.getParameter("educated"));
            user.setEmail(request.getParameter("email"));
            user.setMajor(request.getParameter("major"));
            user.setSchool(request.getParameter("school"));
            user.setSex(request.getParameter("sex"));
            done = userDao.updateUser(user);
            if(done == 1){
                request.getSession().setAttribute("thisUser",user);
                request.getSession().setAttribute("msg","修改成功！");
                response.sendRedirect("userinfo.jsp");
            }
            else {
                request.getSession().setAttribute("msg","信息修改失败！");
                response.sendRedirect("userinfo.jsp");
            }
        }

        //企业基本信息修改
        else if(type.equals("0")){
            CmpDao cmpDao = new CmpDao();
            int done = 0;
            Cmp oldCmp = (Cmp) request.getSession().getAttribute("thisCmp");
            Cmp cmp = oldCmp.clone();
            cmp.setFullname(request.getParameter("fullname"));
            cmp.setAddress(request.getParameter("address"));
            cmp.setIndustry(request.getParameter("industry"));
            cmp.setMgrname(request.getParameter("mgrname"));
            cmp.setMgrpn(request.getParameter("mgrpn"));
            done = cmpDao.updateCmp(cmp);
            if(done == 1){
                request.getSession().setAttribute("thisCmp",cmp);
                request.getSession().setAttribute("msg","修改成功！");
                response.sendRedirect("userinfo.jsp");
            }
            else {
                request.getSession().setAttribute("msg","信息修改失败！");
                response.sendRedirect("userinfo.jsp");
            }
        }


        //企业登陆密码修改
        else if(type.equals("2")){
            String oldPasswd = request.getParameter("oldpasswd");
            String newPasswd = request.getParameter("newpasswd");
            String newPasswd2 = request.getParameter("newpasswd2");
            CmpDao cmpDao = new CmpDao();
            int done = 0;
            Cmp oldCmp = (Cmp) request.getSession().getAttribute("thisCmp");
            Cmp cmp = oldCmp.clone();
            if (!newPasswd.equals(newPasswd2)){
                request.getSession().setAttribute("msg","两次密码不同！");
                response.sendRedirect("userinfo.jsp");
            }
            else if (!newPasswd.equals(oldCmp.getPasswd())){
                request.getSession().setAttribute("msg","密码错误！");
                response.sendRedirect("userinfo.jsp");
            }
            else{
                cmp.setPasswd(newPasswd);
                done = cmpDao.updateCmp(cmp);
                if (done == 1){
                    request.getSession().setAttribute("thisCmp",cmp);
                    request.getSession().setAttribute("msg","密码修改成功！");
                    response.sendRedirect("userinfo.jsp");
                }
                else {
                    request.getSession().setAttribute("msg","系统错误！");
                    response.sendRedirect("userinfo.jsp");
                }
            }
        }

        //个人登陆密码修改
        else if (type.equals("3")){
            String oldPasswd = request.getParameter("oldpasswd");
            String newPasswd = request.getParameter("newpasswd");
            String newPasswd2 = request.getParameter("newpasswd2");
            UserDao userDao = new UserDao();
            int done = 0;
            User oldUser = (User) request.getSession().getAttribute("thisUser");
            User user = oldUser.clone();
            if (!newPasswd.equals(newPasswd2)){
                request.getSession().setAttribute("msg","两次密码不同！");
                response.sendRedirect("userinfo.jsp");
            }
            else if (!oldPasswd.equals(oldUser.getPasswd())){
                request.getSession().setAttribute("msg","密码错误！");
                response.sendRedirect("userinfo.jsp");
            }
            else{
                user.setPasswd(newPasswd);
                done = userDao.updateUser(user);
                if (done == 1){
                    request.getSession().setAttribute("thisUser",user);
                    request.getSession().setAttribute("msg","密码修改成功！");
                    response.sendRedirect("userinfo.jsp");
                }
                else {
                    request.getSession().setAttribute("msg","系统错误！");
                    response.sendRedirect("userinfo.jsp");
                }
            }
        }
        else {
            request.getSession().setAttribute("msg","系统错误!");
            response.sendRedirect("userinfo.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
