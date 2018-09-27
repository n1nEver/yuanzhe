package msg;

public class Recruits extends Msg{
    private int id;
    private String job;
    private String sal;
    private String edu_need;
    private String more_info;
    private int cmpid;
    private String cmpname;

    public Recruits(int id, String job, String sal, String edu_need, String more_info, int cmpid, String cmpname) {
        this.id = id;
        this.job = job;
        this.sal = sal;
        this.edu_need = edu_need;
        this.more_info = more_info;
        this.cmpid = cmpid;
        this.cmpname = cmpname;
    }

    public Recruits(String job, String sal, String edu_need, String more_info, int cmpid, String cmpname) {
        this.job = job;
        this.sal = sal;
        this.edu_need = edu_need;
        this.more_info = more_info;
        this.cmpid = cmpid;
        this.cmpname = cmpname;
    }

    public Recruits() {
    }

    public String getCmpname() {
        return cmpname;
    }

    public void setCmpname(String cmpname) {
        this.cmpname = cmpname;
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

    public String getEdu_need() {
        return edu_need;
    }

    public void setEdu_need(String edu_need) {
        this.edu_need = edu_need;
    }

    public String getMore_info() {
        return more_info;
    }

    public void setMore_info(String more_info) {
        this.more_info = more_info;
    }

    public int getCmpid() {
        return cmpid;
    }

    public void setCmpid(int cmpid) {
        this.cmpid = cmpid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
