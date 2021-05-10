package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.stereotype.Service;

@Service
public class NameModel {

    public int getNameLength(String name) {
        return name.length();
    }

}
