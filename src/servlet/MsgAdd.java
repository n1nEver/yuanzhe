package servlet;

import dao.*;
import msg.Apply;
import msg.Invitation;
import msg.Recruits;
import msg.Wantting;
import users.Cmp;
import users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MsgAdd")
public class MsgAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getSession().setAttribute("msg", null);

        String type = request.getParameter("type");


        if(request.getParameter("job").equals("")){
            request.getSession().setAttribute("msg","请填写必要信息！");
            response.sendRedirect("otherUserinfo.jsp");
        }

        else if (type.equals("1")){
            int done = 0;
            Cmp thisCmp = (Cmp) request.getSession().getAttribute("thisCmp");
            User otherUser = (User) request.getSession().getAttribute("otherUser");
            InvitationDao invitationDao = new InvitationDao();
            Invitation invitation = new Invitation(request.getParameter("job"),
                    request.getParameter("more_info"),
                    otherUser.getId(),
                    thisCmp.getId(),
                    otherUser.getName(),
                    thisCmp.getFullname()
                    );
            done = invitationDao.addMsg(invitation);
            if(done == 1){
                request.getSession().setAttribute("msg","邀请成功！");
                response.sendRedirect("otherUserinfo.jsp");
            }
        }
        else if(type.equals("0")){
            int done = 0;

            User thisUser = (User) request.getSession().getAttribute("thisUser");

            Cmp otherCmp = (Cmp) request.getSession().getAttribute("otherCmp");

            ApplyDao applyDao = new ApplyDao();

            Apply apply = new Apply(request.getParameter("job"),
                    request.getParameter("more_info"),
                    thisUser.getId(),
                    otherCmp.getId(),
                    thisUser.getName(),
                    otherCmp.getFullname());
            done = applyDao.addMsg(apply);

            if(done == 1){
                request.getSession().setAttribute("msg","申请成功！");
                response.sendRedirect("otherUserinfo.jsp");
            }
        }

        else if(type.equals("3")){
            int done = 0;

            User thisUser = (User) request.getSession().getAttribute("thisUser");

            WanttingDao wanttingDao = new WanttingDao();

            Wantting wantting = new Wantting(thisUser.getId(),
                    request.getParameter("job"),
                    request.getParameter("sal"),
                    request.getParameter("username"));

            done = wanttingDao.addMsg(wantting);

            if(done == 1){
                request.getSession().setAttribute("msg","成功！");
                response.sendRedirect("otherUserinfo.jsp");
            }


        }
        else if(type.equals("2")){

            int done = 0;

            Cmp thisCmp = (Cmp) request.getSession().getAttribute("thisCmp");

            RecruitsDao recruitsDao = new RecruitsDao();

            Recruits recruits = new Recruits(request.getParameter("job"),
                        request.getParameter("sal"),
                    request.getParameter("edu_need"),
                    request.getParameter("more_info"),
                    thisCmp.getId(),
                    thisCmp.getFullname());
            done = recruitsDao.addMsg(recruits);
            if(done == 1){
                request.getSession().setAttribute("msg","成功！");
                response.sendRedirect("otherUserinfo.jsp");
            }
        }
        else {
            request.getSession().setAttribute("msg","系统出错！");
            response.sendRedirect("otherUserinfo.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
