package pl.wroc.assa.ASSA_II_2020_spring.semetr2zadanie02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @ModelAttribute("isAnswered")
    public boolean isAnswered() {
        return quizService.isAnswered();
    }

    @GetMapping("/semestr_2_zadanie_02")
    public String semestr2Zadanie02(Model model) {
        model.addAttribute("quiz", quizService.getQuizForm());
        return "semestr_2_zadanie_02";
    }

    @PostMapping("/semestr_2_zadanie_02/edit")
    public String edit() {
        quizService.edit();
        return "redirect:/semestr_2_zadanie_02";
    }

    @PostMapping("/semestr_2_zadanie_02/reset")
    public String reset() {
        quizService.reset();
        return "redirect:/semestr_2_zadanie_02";
    }

    @PostMapping("/semestr_2_zadanie_02/process")
    public String quizFormProcess(@ModelAttribute("quiz") QuizForm quizForm) {
        quizService.save(quizForm);
        return "redirect:/semestr_2_zadanie_02";
    }

}
