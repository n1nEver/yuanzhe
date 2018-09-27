package servlet;

import dao.DBDao;
import dao.RecruitsDao;
import dao.WanttingDao;
import msg.Recruits;
import msg.Wantting;


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



@WebServlet(name = "SearchSer")
public class SearchSer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getSession().setAttribute("msg", null);

        String type = request.getParameter("type");
        String text = request.getParameter("search_info");
        if (type.equals("1")) {
            List<Wantting> wanttingList = new ArrayList<Wantting>();
            DBDao dbDao = new DBDao();
            ResultSet resultSet = dbDao.querry("select * from wantting where job like '%" + text + "%'");
            try {
                while (resultSet.next()) {
                    wanttingList.add(new Wantting(resultSet.getInt("userid"),
                            resultSet.getString("job"),
                            resultSet.getString("sal"),
                            resultSet.getString("username")));
                }
            } catch (Exception e) {

            }
            request.getSession().setAttribute("wanttingList", wanttingList);
            response.sendRedirect("wantting.jsp");
        } else if (type.equals("0")) {
            List<Recruits> recruitsList = new ArrayList<Recruits>();
            DBDao dbDao = new DBDao();
            ResultSet resultSet = dbDao.querry("select * from recruits where job like '%" + text + "%'");
            try {
                while (resultSet.next()) {
                    recruitsList.add(new Recruits(
                            resultSet.getString("job"),
                            resultSet.getString("sal"),
                            resultSet.getString("edu_need"),
                            resultSet.getString("more_info"),
                            resultSet.getInt("cmpid"),
                            resultSet.getString("cmpname")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("recruitsList", recruitsList);
            response.sendRedirect("recruits.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
