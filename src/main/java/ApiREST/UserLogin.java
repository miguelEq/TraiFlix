package ApiREST;

public class UserLogin {
    private String username;
    private String password;
    public UserLogin(){}

    public UserLogin(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
