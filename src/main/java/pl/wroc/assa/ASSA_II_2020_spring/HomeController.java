package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final NameModel nameModel;

    public HomeController(NameModel nameModel) {
        this.nameModel = nameModel;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/name_app")
    public String nameApp() {
        return "name_app";
    }

    @PostMapping("/name/process")
    public String nameProcess(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("nameLength", nameModel.getNameLength(name));
        return "name_app";
    }
}
