package pl.wroc.assa.ASSA_II_2020_spring.quiz;

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

    @GetMapping("/quiz")
    public String quiz(Model model) {
        model.addAttribute("quiz", quizService.getQuizForm());
        return "quiz";
    }

    @PostMapping("/quiz/edit")
    public String edit() {
        quizService.edit();
        return "redirect:/quiz";
    }

    @PostMapping("/quiz/reset")
    public String reset() {
        quizService.reset();
        return "redirect:/quiz";
    }

    @PostMapping("/quiz/process")
    public String quizFormProcess(@ModelAttribute("quiz") QuizForm quizForm) {
        quizService.save(quizForm);
        return "redirect:/quiz";
    }

}
