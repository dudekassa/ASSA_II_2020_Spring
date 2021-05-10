package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
