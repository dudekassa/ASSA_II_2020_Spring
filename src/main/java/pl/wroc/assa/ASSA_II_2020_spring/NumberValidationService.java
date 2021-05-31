package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

@Service
public class NumberValidationService {

    public boolean isValidNumber(String number) {
        int validDigitNumber = 9;
        return number.length() == validDigitNumber;
    }
}
