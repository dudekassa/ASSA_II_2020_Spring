package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wroc.assa.ASSA_II_2020_spring.authentication.AuthService;
import pl.wroc.assa.ASSA_II_2020_spring.authentication.LoginForm;
import pl.wroc.assa.ASSA_II_2020_spring.authentication.SessionService;
import pl.wroc.assa.ASSA_II_2020_spring.authentication.UserService;
import pl.wroc.assa.ASSA_II_2020_spring.nameapp.NameService;

@Controller
public class HomeController {

    private final NameService nameService;
    private final AuthService authService;
    private final SessionService sessionService;
    private final UserService userService;

    public HomeController(NameService nameService, AuthService authService, SessionService sessionService, UserService userService) {
        this.nameService = nameService;
        this.authService = authService;
        this.sessionService = sessionService;
        this.userService = userService;
    }




    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        model.addAttribute("isLogin", sessionService.isLogin());
        model.addAttribute("userName", sessionService.getUserName());
        model.addAttribute("users", authService.getUsers());
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/example_link")
    public String exampleLink(Model model) {
        String name = "Dudek";
        model.addAttribute("nameSize", nameService.getNameSize(name));
        model.addAttribute("name", name);

        return "example_link";
    }
}
