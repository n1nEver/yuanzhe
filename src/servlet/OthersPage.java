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

@WebServlet(name = "OthersPage")
public class OthersPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getSession().setAttribute("msg", null);
        request.getSession().setAttribute("otherUser",null);
        request.getSession().setAttribute("otherCmp",null);

        String type = request.getParameter("type");


        if (type.equals("1")){
            User theOtherUser  = null;
            UserDao userDao = new UserDao();
            String userid = request.getParameter("userid");
            theOtherUser = userDao.queryById(userid);
            request.getSession().setAttribute("otherUser",theOtherUser);
            response.sendRedirect("otherUserinfo.jsp");
        }
        else if (type.equals("0")){
            Cmp theOtherCmp = null;
            CmpDao cmpDao = new CmpDao() ;
            String cmpid = request.getParameter("cmpid");
            theOtherCmp = cmpDao.queryById(cmpid);
            request.getSession().setAttribute("otherCmp",theOtherCmp);
            response.sendRedirect("otherUserinfo.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
