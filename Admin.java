package myProjects;

public class Admin {
    private String username;
    private int password;
    public Admin(String username, int password){
        this.username = username;
        this.password = password;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
