package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

@Service
public class NumberValidationService {

    public boolean isValidNumber(String number) {

        String numberWithoutDash = number.replaceAll("-","");
        int validDigitNumber = 9;
        char[] numberArray =  numberWithoutDash.trim().toCharArray();
        boolean isDigit = true;

        for (int i = 0; i < numberArray.length; i++) {
            if (!Character.isDigit(numberArray[i])) {
                isDigit = false;
                break;
            }
        }

        return numberWithoutDash.trim().length() == validDigitNumber && isDigit;
    }
}
