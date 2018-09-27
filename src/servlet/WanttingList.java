package servlet;

import dao.DBDao;
import dao.WanttingDao;
import msg.Wantting;
import users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "WanttingList")
public class WanttingList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getSession().setAttribute("msg", null);

        String type = request.getParameter("type");
        List<Wantting> wanttingList = null;
        WanttingDao wanttingDao = new WanttingDao();

        if(type == null){
            wanttingList = wanttingDao.listAll();
            request.getSession().setAttribute("wanttingList",wanttingList);
            response.sendRedirect("wantting.jsp");
        }
        else if(type.equals("0")){
            User thisUser = (User) request.getSession().getAttribute("thisUser");
            wanttingList = wanttingDao.querryByUserid(thisUser.getId());
            request.getSession().setAttribute("wanttingList",wanttingList);
            response.sendRedirect("wantting.jsp");
        }
        else {
            request.getSession().setAttribute("msg","系统错误");
            response.sendRedirect("wantting.jsp");
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
