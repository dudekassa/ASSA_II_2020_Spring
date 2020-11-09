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
        String name = "Przemyslaw";
        model.addAttribute("nameSize", nameService.getNameSize(name));
        model.addAttribute("isEvenLettersInName", nameService.isEvenLettersInName(name));
        model.addAttribute("getName", new GetNameForm());
        return "index";
    }

    @GetMapping("/example_link")
    public String exampleLink(Model model) {
        String name = "Dudek";
        model.addAttribute("nameSize", nameService.getNameSize(name));
        model.addAttribute("name", name);

        return "example_link";
    }

    //tutaj ma byc Twój link

}
