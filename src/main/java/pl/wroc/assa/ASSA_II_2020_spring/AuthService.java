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
    }

    public boolean tryLogin(String password) {
        return password.equals(PASSWORD);
    }
}
