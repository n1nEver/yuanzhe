package dao;

import msg.Apply;
import msg.Invitation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplyDao {

    public ResultSet listAll() {
        return null;
    }


    public int addMsg(Apply apply) {
        int done = 0;
        String sql = "insert into apply(job,more_info,userid,cmpid,username,cmpname) values(?,?,?,?,?,?)";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,apply.getJob());
            pstm.setString(2,apply.getMore_info());
            pstm.setInt(3,apply.getUserid());
            pstm.setInt(4,apply.getCmpid());
            pstm.setString(5,apply.getUsername());
            pstm.setString(6,apply.getCmpname());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return done;

    }


    public int delMsg(Apply apply) {
        int done = 0;
        String sql = "delete from apply where id = ?";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,apply.getId());
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

    public List<Apply> querryByCmpid(int cmpId){
        List<Apply> applyList = new ArrayList<Apply>();
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from apply where cmpid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,cmpId);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                applyList.add(new Apply(resultSet.getInt("id"),
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
        return applyList;
    }

    public List<Apply> querryByUserId(String userId){
        List<Apply> applyList = new ArrayList<Apply>();
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from apply where userid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,userId);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                applyList.add(new Apply(resultSet.getInt("id"),
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
        return applyList;
    }
}
