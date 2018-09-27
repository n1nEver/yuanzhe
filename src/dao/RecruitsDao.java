package dao;

import msg.Recruits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruitsDao  {
    public List<Recruits> listAll() {
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        resultSet = dbDao.querry("select * from recruits");
        List<Recruits> recruitsList = new ArrayList<Recruits>();
        try {
            while(resultSet.next()){
                recruitsList.add(new Recruits(
                        resultSet.getString("job"),
                        resultSet.getString("sal"),
                        resultSet.getString("edu_need"),
                        resultSet.getString("more_info"),
                        resultSet.getInt("cmpid"),
                        resultSet.getString("cmpname")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recruitsList;
    }

    public int addMsg(Recruits recruits) {
        int done = 0;
        String sql = "insert into recruits(job,sal,edu_need,mort_info,cmpname,cmp_id) values(?,?,?,?,?,?)";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,recruits.getJob());
            pstm.setString(2,recruits.getSal());
            pstm.setString(3,recruits.getEdu_need());
            pstm.setString(4,recruits.getMore_info());
            pstm.setString(5,recruits.getCmpname());
            pstm.setInt(6,recruits.getCmpid());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return done;
    }

    public int delMsg(Recruits recruits) {
        int done = 0;
        String sql = "delete from recruits where id = ?";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,recruits.getId());
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

    public List<Recruits> querryByCmpId(int cmpId) {
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = ("select * from recruits where cmpid = ?");
        List<Recruits> recruitsList = new ArrayList<Recruits>();

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,cmpId);
            while(resultSet.next()){
                recruitsList.add(new Recruits(
                        resultSet.getString("job"),
                        resultSet.getString("sal"),
                        resultSet.getString("edu_need"),
                        resultSet.getString("more_info"),
                        resultSet.getInt("cmpid"),
                        resultSet.getString("cmpname")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recruitsList;
    }

}
