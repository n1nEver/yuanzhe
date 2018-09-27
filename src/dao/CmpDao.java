package dao;

import users.Cmp;
import users.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CmpDao {

    //列出所有
    public ResultSet listAll() {
        ResultSet rs = null;
        DBDao dbDao = new DBDao();
        String sql = "select * from cmp;";
        rs = dbDao.querry(sql);
        return rs;
    }

    //增添
    public int addCmp(Cmp cmp) {
        int done = 0;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "insert into cmp(fullname , loginname , passwd , address , mgrname , mgrpn , industry ) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cmp.getFullname());
            pstm.setString(2, cmp.getLoginname());
            pstm.setString(3, cmp.getPasswd());
            pstm.setString(4, cmp.getAddress());
            pstm.setString(5, cmp.getMgrname());
            pstm.setString(6, cmp.getMgrpn());
            pstm.setString(7, cmp.getIndustry());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return done;
    }


    public int delCmp(Cmp cmp) {
        int done = 0;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "delete from cmp where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cmp.getId());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return done;
    }


    public int updateCmp(Cmp cmp) {
        int done = 0;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "update cmp set fullname = ? , loginname = ?, passwd = ?, address = ?, mgrname = ?, mgrpn = ?, industry = ? " +
                "where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cmp.getFullname());
            pstm.setString(2, cmp.getLoginname());
            pstm.setString(3, cmp.getPasswd());
            pstm.setString(4, cmp.getAddress());
            pstm.setString(5, cmp.getMgrname());
            pstm.setString(6, cmp.getMgrpn());
            pstm.setString(7, cmp.getIndustry());
            pstm.setInt(8, cmp.getId());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return done;
    }

    public Cmp queryByloginName(String loginName){
        Cmp cmp = null;
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from cmp where loginName = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,loginName);
            resultSet = pstm.executeQuery();
            resultSet.next();
            cmp = new Cmp(resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("loginname"),
                    resultSet.getString("passwd"),
                    resultSet.getString("address"),
                    resultSet.getString("mgrname"),
                    resultSet.getString("mgrpn"),
                    resultSet.getString("industry"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return cmp;
    }


    public Cmp queryById(String id){
        Cmp cmp = null;
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from cmp where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,id);
            resultSet = pstm.executeQuery();
            resultSet.next();
            cmp = new Cmp(resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("loginname"),
                    resultSet.getString("passwd"),
                    resultSet.getString("address"),
                    resultSet.getString("mgrname"),
                    resultSet.getString("mgrpn"),
                    resultSet.getString("industry"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return cmp;
    }


}
