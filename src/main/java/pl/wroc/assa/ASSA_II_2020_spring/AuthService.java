package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final String PASSWORD = "tajne";

    private final Map<String, String> userWithPassword = new HashMap<>();

    private final SessionService sessionService;

    public AuthService(SessionService sessionService) {
        this.sessionService = sessionService;
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
                sessionService.setLogin(true);
                sessionService.setUserName(loginForm.getName());
                return true;
            }
        }
        sessionService.setLogin(false);
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
