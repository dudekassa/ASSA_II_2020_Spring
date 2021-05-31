package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    final private AdultService adultService;
    final private NumberValidationService numberValidationService;

    public HomeController(AdultService adultService, NumberValidationService numberValidationService) {
        this.adultService = adultService;
        this.numberValidationService = numberValidationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("is_adult")
    public String isAdult(@RequestParam(name="date") String date, Model model) {
        model.addAttribute("date", adultService.isAdult(date));
        return "index";
    }

    @PostMapping("is_valid_number")
    public String isValidNumber(@RequestParam(name = "phone_number") String phoneNumber, Model model) {
        model.addAttribute("isValidNumber", numberValidationService.isValidNumber(phoneNumber));

        return "index";
    }

}
