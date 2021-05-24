package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdultService {

    public String isAdult(String date) {

        LocalDate nowDate = LocalDate.now();
        LocalDate userDate =  LocalDate.parse(date);
        LocalDate minAdultDate = nowDate.minusYears(18);
        boolean isAdult = !userDate.isAfter(minAdultDate);



        return "Dzisiejsza data: "  + nowDate
                + ", Twoja data: " + userDate
                + ", Wiek pełnoletności: " + minAdultDate
                + ", czy pełnoletni: " + isAdult;
    }

}
