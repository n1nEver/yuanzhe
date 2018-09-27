package dao;

import java.sql.*;

public class DBDao {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/job";
    private final String user = "root";
    private final String passwd = "1120";
    private Connection conn=null;

    public DBDao()
    {
        try
        {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url,user,passwd);
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("加载驱动失败");
        }
    }

    public void close()
    {
        if(this.conn!=null)
        {
            try
            {
                this.conn.close();
            } catch (Exception e)
            {
                // TODO Auto-generated catch block
                System.out.println("数据库连接关闭失败");
            }
        }
    }

    public ResultSet querry(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement pstm = this.conn.prepareStatement(sql);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int update(String sql) {
        int done = 0;
        ResultSet rs = null;
        try {
            PreparedStatement pstm = this.conn.prepareStatement(sql);
            done = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return done;
    }



    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

}
