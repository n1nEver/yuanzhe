package dao;

import msg.Invitation;
import msg.Wantting;
import servlet.RegisterSer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WanttingDao {

    public List<Wantting> listAll() {
        List<Wantting> wanttingList = new ArrayList<Wantting>();
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        resultSet = dbDao.querry("select * from wantting");
        try {
            while (resultSet.next()){
                wanttingList.add(new Wantting(resultSet.getInt("userid"),
                        resultSet.getString("job"),
                        resultSet.getString("sal"),
                        resultSet.getString("username")));
            }
        }catch (Exception e){

        }finally {
            dbDao.close();
        }

        return wanttingList;
    }

    public int addMsg(Wantting wantting) {
        int done = 0;
        String sql = "insert into wantting(job,sal,userid,username) values(?,?,?,?)";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,wantting.getJob());
            pstm.setString(2,wantting.getSal());
            pstm.setInt(3,wantting.getUserid());
            pstm.setString(4,wantting.getUsername());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return done;
    }

    public int delMsg(Wantting wantting) {
        int done = 0;
        String sql = "delete from wantting where id = ?";
        DBDao dbDao = new DBDao() ;
        Connection conn = dbDao.getConn();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,wantting.getId());
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

    public List<Wantting> querryByUserid(int userId){
        List<Wantting> wanttingList = new ArrayList<Wantting>();
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from wantting where userid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,userId);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                wanttingList.add(new Wantting(resultSet.getInt("userid"),
                        resultSet.getString("job"),
                        resultSet.getString("sal"),
                        resultSet.getString("username")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wanttingList;
    }
}
