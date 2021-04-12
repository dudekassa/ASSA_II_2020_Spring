package pl.wroc.assa.ASSA_II_2020_spring.authentication;

public class LoginForm {

    private String name;
    private String password;

    public LoginForm(String name) {
        this.name = name;
    }

    public LoginForm() {

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
}
