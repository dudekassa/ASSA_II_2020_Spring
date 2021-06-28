package pl.wroc.assa.ASSA_II_2020_spring.semetr2zadanie02;

import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private QuizForm quizForm;
    private boolean answered;

    public void save(QuizForm quizForm) {
        setQuizForm(quizForm);
        answered = true;
    }

    public void edit() {
        answered = false;
    }

    public void reset() {
        quizForm = new QuizForm();
        answered = false;
    }

    public QuizForm getQuizForm() {
        if (quizForm == null) {
            answered = false;
            return new QuizForm();
        } else {
            return quizForm;
        }
    }

    public void setQuizForm(QuizForm quizForm) {
        this.quizForm = quizForm;
    }

    public boolean isAnswered() {
        if (quizForm == null) {
            answered = false;
        }
        return answered;
    }

}
