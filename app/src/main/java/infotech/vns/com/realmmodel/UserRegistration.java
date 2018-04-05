package infotech.vns.com.realmmodel;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class UserRegistration extends RealmObject {
    @Required
    private String fname;
    @Required
    private String lname;
    @Required
    private String mobile;
    @Required
    private String email;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
