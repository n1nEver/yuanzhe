package msg;

public class Wantting extends Msg{
    private int id;
    private int userid;
    private String job;
    private String sal;
    private String username;

    public Wantting() {
    }

    public Wantting(int userid, String job, String sal,String username) {
        this.userid = userid;
        this.job = job;
        this.sal = sal;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
