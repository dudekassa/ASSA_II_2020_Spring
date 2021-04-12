package pl.wroc.assa.ASSA_II_2020_spring.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wroc.assa.ASSA_II_2020_spring.nameapp.NameService;

@Controller
public class AuthController {

    private final NameService nameService;
    private final AuthService authService;
    private final SessionService sessionService;
    private final UserService userService;

    public AuthController(NameService nameService, AuthService authService, SessionService sessionService, UserService userService) {
        this.nameService = nameService;
        this.authService = authService;
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        boolean isLogout = authService.logout();
        redirectAttributes.addFlashAttribute("isLogout", isLogout);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm,
                        RedirectAttributes redirectAttributes) {
        boolean isLogin = authService.tryLogin(loginForm);
        String message = "";
        if (isLogin) {
            message = "Udało się zalogować";
        } else {
            message = "Nie udało się zalogować";
        }
        redirectAttributes.addFlashAttribute("loginMessage", message);
        redirectAttributes.addFlashAttribute("name", loginForm.getName().toUpperCase());
        redirectAttributes.addFlashAttribute("nameSize", nameService.getNameSize(loginForm.getName()));
        redirectAttributes.addFlashAttribute("isEvenLettersInName", nameService.isEvenLettersInName(loginForm.getName()));

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerForm") RegisterForm registerForm,
                           RedirectAttributes redirectAttributes) {
        boolean isRegister = authService.tryRegister(registerForm);
        String registerMessage;
        if (isRegister) {
            registerMessage = "Rejestracja udana - spróbuj się zalogować";
        } else {
            registerMessage = "Rejestracja nie udana";
        }
        redirectAttributes.addFlashAttribute("isRegister", registerMessage);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/change_password")
    public String changePassword(Model model) {
        model.addAttribute("changePasswordForm", new ChangePasswordForm());
        return "change_password";
    }

    @PostMapping("/change_password")
    public String changePassword(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,
                                 RedirectAttributes redirectAttributes) {

        authService.changePassword(changePasswordForm);
        return "redirect:/";
    }
}
