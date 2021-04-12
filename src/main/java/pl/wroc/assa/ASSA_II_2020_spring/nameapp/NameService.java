package pl.wroc.assa.ASSA_II_2020_spring.nameapp;


import org.springframework.stereotype.Service;

@Service
public class NameService {


    public int getNameSize(String name) {
        return name.length();
    }

    public boolean isEvenLettersInName(String name) {
        int lettersInName = getNameSize(name);
        if (lettersInName % 2 == 0) {
            return true;
        }
        return false;
    }

}
