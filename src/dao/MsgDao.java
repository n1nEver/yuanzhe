package dao;

import java.sql.ResultSet;

public interface MsgDao {
    public ResultSet listAll();
    public int addMsg();
    public int delMsg();
    public int updateMsg();
    public ResultSet querry();
}
