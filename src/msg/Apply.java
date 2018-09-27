package msg;

public class Apply extends Msg{
    private int id;
    private String job;
    private String more_info;
    private int userid;
    private int cmpid;
    private String username;
    private String cmpname;

    public Apply(String job, String more_info, int userid, int cmpid, String username, String cmpname) {
        this.job = job;
        this.more_info = more_info;
        this.userid = userid;
        this.cmpid = cmpid;
        this.username = username;
        this.cmpname = cmpname;
    }

    public Apply(int id, String job, String more_info, int userid, int cmpid, String username, String cmpname) {
        this.id = id;
        this.job = job;
        this.more_info = more_info;
        this.userid = userid;
        this.cmpid = cmpid;
        this.username = username;
        this.cmpname = cmpname;
    }

    public Apply() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCmpname() {
        return cmpname;
    }

    public void setCmpname(String cmpname) {
        this.cmpname = cmpname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMore_info() {
        return more_info;
    }

    public void setMore_info(String more_info) {
        this.more_info = more_info;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCmpid() {
        return cmpid;
    }

    public void setCmpid(int cmpid) {
        this.cmpid = cmpid;
    }
}
