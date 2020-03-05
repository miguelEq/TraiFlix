package ApiREST;

public class UserView {
    private String name;
    private String username;
    public UserView(){}
    public UserView(String username,String name){
      this.username=username;
      this.name= name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }
}
