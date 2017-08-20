package bean;

/**
 * Created by WHZ on 2017/8/15 0015.
 */
public class User {
    private String userName;
    private String email;
    public User(String userName, String email){
        this.userName = userName;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
