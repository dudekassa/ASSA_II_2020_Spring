package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    private final String PASSWORD = "tajne";

    private final Map<String, String> userWithPassword = new HashMap<>();

    private final SessionService sessionService;

    private final UserRepository userRepository;

    public AuthService(SessionService sessionService, UserRepository userRepository) {
        this.sessionService = sessionService;
        this.userRepository = userRepository;
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
            User user = new User();
            user.setLogin(registerForm.getName());
            user.setPassword(registerForm.getPassword());
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public boolean logout() {
        sessionService.setUserName(null);
        sessionService.setLogin(false);
        return !sessionService.isLogin();
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
