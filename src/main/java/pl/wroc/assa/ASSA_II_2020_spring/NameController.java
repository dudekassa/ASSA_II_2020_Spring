package pl.wroc.assa.ASSA_II_2020_spring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NameController {

    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/")
    public String home(Model model) {
        String name = "Przemek";
        model.addAttribute("nameSize", nameService.getNameSize(name));

        return "index";
    }

}
