package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdultService {

    public String isAdult(String date) {

        LocalDate nowDate = LocalDate.now();
        LocalDate userDate =  LocalDate.parse(date);
        LocalDate minAdultDate = nowDate.minusYears(18);

        /*
        01-06-2003 - data pełnoletności

        data urodzenia == data pełnoletności (pełnoletni)       isAfter false   isBefore false
        data urodzenia < data pełnoletności (pełnoletni)        isAfter false   isBefore true
        data urodzenia > data pełnoletności (niepełnoletni)     isAfter true    isBefore false



         */
        boolean isAdult = !userDate.isAfter(minAdultDate);



        return "Dzisiejsza data: "  + nowDate
                + ", Twoja data: " + userDate
                + ", Wiek pełnoletności: " + minAdultDate
                + ", czy pełnoletni: " + isAdult;
    }

}
