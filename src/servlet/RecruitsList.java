package servlet;

import dao.RecruitsDao;
import dao.WanttingDao;
import msg.Recruits;
import msg.Wantting;
import users.Cmp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RecruitsList")
public class RecruitsList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getSession().setAttribute("msg", null);


        String type = request.getParameter("type");
        List<Recruits> recruitsList = null;
        RecruitsDao recruitsDao = new RecruitsDao();

        if(type == null){
            recruitsList = recruitsDao.listAll();
            request.getSession().setAttribute("recruitsList",recruitsList);
            response.sendRedirect("recruits.jsp");
        }
        else if(type.equals("0")){
            Cmp thisCmp = (Cmp) request.getSession().getAttribute("thisCmp");
            recruitsList = recruitsDao.querryByCmpId(thisCmp.getId());
            request.getSession().setAttribute("recruitsList",recruitsList);
            response.sendRedirect("recruits.jsp");

        }
        else {
            request.getSession().setAttribute("msg","系统错误");
            response.sendRedirect("recruits.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
