package ApiREST;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserView {
    private String name;
    private String username;
    private String fechaDeNacimiento;
    public UserView(){}
    public UserView(String username,String name,String fechaDeNacimiento){
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
}
