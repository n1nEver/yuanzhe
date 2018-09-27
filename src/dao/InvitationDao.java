package dao;

import msg.Invitation;
import msg.Recruits;

import java.io.LineNumberInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvitationDao  {

    public ResultSet listAll() {
        return null;
    }


    public int addMsg(Invitation invitation) {
        int done = 0;
        String sql = "insert into invitation(job,more_info,userid,cmpid,username,cmpname) values(?,?,?,?,?,?)";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,invitation.getJob());
            pstm.setString(2,invitation.getMore_info());
            pstm.setInt(3,invitation.getUserid());
            pstm.setInt(4,invitation.getCmpid());
            pstm.setString(5,invitation.getUsername());
            pstm.setString(6,invitation.getCmpname());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return done;
    }


    public int delMsg(Invitation invitation) {
        int done = 0;
        String sql = "delete from invitation where id = ?";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,invitation .getId());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return done;
    }


    public int updateMsg() {
        return 0;
    }


    public ResultSet querry() {
        return null;
    }

    public List<Invitation> querryByUserid(int userId){
        List<Invitation> invitationList = new ArrayList<Invitation>();
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from invitation where userid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,userId);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                invitationList.add(new Invitation(resultSet.getInt("id"),
                        resultSet.getString("job"),
                        resultSet.getString("more_info"),
                        resultSet.getInt("userid"),
                        resultSet.getInt("cmpid"),
                        resultSet.getString("username"),
                        resultSet.getString("cmpname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invitationList;
    }


    public List<Invitation> querryByCmpid(String cmpId){
        List<Invitation> invitationList = new ArrayList<Invitation>();
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from invitation where cmpid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,cmpId);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                invitationList.add(new Invitation(resultSet.getInt("id"),
                        resultSet.getString("job"),
                        resultSet.getString("more_info"),
                        resultSet.getInt("userid"),
                        resultSet.getInt("cmpid"),
                        resultSet.getString("username"),
                        resultSet.getString("cmpname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invitationList;
    }
}
