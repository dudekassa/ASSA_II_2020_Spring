package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final String PASSWORD = "tajne";

    public boolean tryLogin(String password) {
        return password.equals(PASSWORD);
    }
}
