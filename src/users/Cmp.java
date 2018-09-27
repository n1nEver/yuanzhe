package users;

public class Cmp extends Users implements Cloneable{
    private int id;
    private String fullname;
    private String loginname;
    private String passwd;
    private String address;
    private String mgrname;
    private String mgrpn;
    private String industry;

    public Cmp() {
    }

    public Cmp(String fullname, String loginname, String passwd) {
        this.fullname = fullname;
        this.loginname = loginname;
        this.passwd = passwd;
    }

    public Cmp(String fullname, String loginname, String passwd, String address, String mgrname, String mgrpn, String industry) {
        this.fullname = fullname;
        this.loginname = loginname;
        this.passwd = passwd;
        this.address = address;
        this.mgrname = mgrname;
        this.mgrpn = mgrpn;
        this.industry = industry;
    }

    public Cmp(int id, String fullname, String loginname, String passwd, String address, String mgrname, String mgrpn, String industry) {
        this.id = id;
        this.fullname = fullname;
        this.loginname = loginname;
        this.passwd = passwd;
        this.address = address;
        this.mgrname = mgrname;
        this.mgrpn = mgrpn;
        this.industry = industry;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMgrname() {
        return mgrname;
    }

    public void setMgrname(String mgrname) {
        this.mgrname = mgrname;
    }

    public String getMgrpn() {
        return mgrpn;
    }

    public void setMgrpn(String mgrpn) {
        this.mgrpn = mgrpn;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Cmp clone() {
        Cmp cmp = null;
        try {
            cmp = (Cmp) super.clone();
        }catch (Exception e){

        }

        return cmp;
    }
}
