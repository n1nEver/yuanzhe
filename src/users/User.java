package users;

public class User extends Users implements Cloneable{
    private int id;
    private String name;
    private String sex;
    private String email;
    private String phonenum;
    private String educated;
    private String school;
    private String major;
    private String passwd;
    private String birth;


    public User(){

    }



    public User(String name, String sex, String phonenum, String passwd) {
        this.name = name;
        this.sex = sex;
        this.phonenum = phonenum;
        this.passwd = passwd;
    }

    public User(String name, String sex, String email, String phonenum, String educated, String school, String major, String passwd) {

        this.name = name;
        this.sex = sex;
        this.email = email;
        this.phonenum = phonenum;
        this.educated = educated;
        this.school = school;
        this.major = major;
        this.passwd = passwd;
    }

    public User(String name, String sex, String email, String phonenum, String educated, String school, String major, String passwd, String birth) {
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.phonenum = phonenum;
        this.educated = educated;
        this.school = school;
        this.major = major;
        this.passwd = passwd;
        this.birth = birth;
    }

    public User(int id, String name, String sex, String email, String phonenum, String educated, String school, String major, String passwd, String birth) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.phonenum = phonenum;
        this.educated = educated;
        this.school = school;
        this.major = major;
        this.passwd = passwd;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEducated() {
        return educated;
    }

    public void setEducated(String educated) {
        this.educated = educated;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public User clone() {
        User user = null;
        try {
            user = (User) super.clone();
        }catch (Exception e){

        }

        return user;
    }
}
