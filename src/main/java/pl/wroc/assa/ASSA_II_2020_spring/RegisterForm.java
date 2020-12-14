package pl.wroc.assa.ASSA_II_2020_spring;

public class RegisterForm {

    private String name;
    private String password;
    private String repeatPassword;


    public RegisterForm() {
        //constructor - tworzy obiekt = inicjalizuje obiekt - tworzy instancję
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return this.repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
