package dao;

import users.Cmp;
import users.User;
import users.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    //查询所有个人用户的所有信息
    public ResultSet listAll() {
        ResultSet rs = null;
        DBDao dbDao = new DBDao();
        String sql = "select * from user;";
        rs = dbDao.querry(sql);
        return rs;
    }


    //添加一条个人用户信息
    public int addUser(User user) {
        int done = 0;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "insert into user(name,birth,sex,email,phonenum,educated,school,major,passwd) values (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getBirth());
            pstm.setString(3,user.getSex());
            pstm.setString(4,user.getEmail());
            pstm.setString(5,user.getPhonenum());
            pstm.setString(6,user.getEducated());
            pstm.setString(7,user.getSchool());
            pstm.setString(8,user.getMajor());
            pstm.setString(9,user.getPasswd());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return done;
    }



//删除一条信息
    public int delUser(User user) {
        int done = 0 ;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "delete from user where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,user.getId());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return done;
    }


//更新一条信息
    public int updateUser(User user) {
        int done = 0;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "update user set name = ?,birth = ?,sex = ?" +
                ",email = ?,phonenum = ?,educated = ?,school = ?,major = ?,passwd = ?" +
                "where id = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getBirth());
            pstm.setString(3,user.getSex());
            pstm.setString(4,user.getEmail());
            pstm.setString(5,user.getPhonenum());
            pstm.setString(6,user.getEducated());
            pstm.setString(7,user.getSchool());
            pstm.setString(8,user.getMajor());
            pstm.setString(9,user.getPasswd());
            pstm.setInt(10,user.getId());
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return done;
    }

    public User queryByloginName(String phonenum){
        User user = null;
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from user where phonenum = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,phonenum);
            resultSet = pstm.executeQuery();
            resultSet.next();
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("sex"),
                    resultSet.getString("email"),
                    resultSet.getString("phonenum"),
                    resultSet.getString("educated"),
                    resultSet.getString("school"),
                    resultSet.getString("major"),
                    resultSet.getString("passwd"),
                    resultSet.getString("birth"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return user;
    }


    public User queryById(String id){
        User user = null;
        ResultSet resultSet = null;
        DBDao dbDao = new DBDao();
        Connection conn = dbDao.getConn();
        String sql = "select * from user where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,id);
            resultSet = pstm.executeQuery();
            resultSet.next();
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("sex"),
                    resultSet.getString("email"),
                    resultSet.getString("phonenum"),
                    resultSet.getString("educated"),
                    resultSet.getString("school"),
                    resultSet.getString("major"),
                    resultSet.getString("passwd"),
                    resultSet.getString("birth"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbDao.close();
        }
        return user;
    }

}
