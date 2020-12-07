package pl.wroc.assa.ASSA_II_2020_spring;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    public void createAnimalList() {

        Animal kot1 = new Animal("Filemon");
        Animal kot2 = new Animal("Puszek");
        Animal kot3 = new Animal("Bonifacy");

        List<Animal> animalList = new ArrayList<>();

        animalList.add(kot1);
        animalList.add(kot2);
        animalList.add(kot3);

        for (Animal animal : animalList) {
            animal.getName();
        }

    }


}
