package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionService {
    private String userName;
    private boolean isLogin;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
