package info.thecodinglive.api.vo;

import java.io.Serializable;

public class UserVO implements Serializable{


    private String sec_id;
    private String passwd;
    private String nickNM;
    private String email;

    public String getSec_id() {
        return sec_id;
    }

    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickNM() {
        return nickNM;
    }

    public void setNickNM(String nickNM) {
        this.nickNM = nickNM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
