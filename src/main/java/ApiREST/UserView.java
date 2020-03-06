package ApiREST;



public class UserView {
    private String name;
    private String username;
    private String fechaDeNacimiento;
    private String password;
    public UserView(){}
    public UserView(String username,String name,String fechaDeNacimiento,String password){
      this.username=username;
      this.name= name;
      this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getPassword() {
        return password;
    }
}
