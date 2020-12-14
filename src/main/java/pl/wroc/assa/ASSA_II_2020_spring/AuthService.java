package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final String PASSWORD = "tajne";

    private final Map<String, String> userWithPassword = new HashMap<>();

    public AuthService() {
        userWithPassword.put("przemek", "tajne");
        userWithPassword.put("leszek", "kot");
        userWithPassword.put("antoni", "papuga");
    }

    public boolean tryLogin(String password) {
        return password.equals(PASSWORD);
    }

    public boolean tryLogin(LoginForm loginForm) {

        boolean isUserNameInDB = userWithPassword.containsKey(loginForm.getName());

        if (isUserNameInDB) {
            boolean isPasswordCorrect = userWithPassword.get(loginForm.getName()).equals(loginForm.getPassword());
            if (isPasswordCorrect) {
                return true;
            }
        }

        return false;
    }

    public boolean tryRegister(RegisterForm registerForm) {

        String password = registerForm.getPassword();
        String repeatPassword = registerForm.getRepeatPassword();

        boolean passwordEquals = password.equals(repeatPassword);

        if (passwordEquals) {
            userWithPassword.put(registerForm.getName(), registerForm.getPassword());
            return true;
        }

        return false;
    }
}
