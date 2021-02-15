package se.lexicon.teri.data;

import se.lexicon.teri.models.Car;
import se.lexicon.teri.models.Owner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static se.lexicon.teri.data.OwnerRegister.getOwnerRegister;

public class CarRegister {

    public static List<Car> getCarRegister() {
        List<Owner> ownerRegister = getOwnerRegister();

        return Arrays.asList(
                new Car("ABC 123", "Ford", "Anglia", LocalDate.parse("2020-09-01"), ownerRegister.get(0)),
                new Car("XYZ 987", "Renault", "Clio", LocalDate.parse("2021-01-01"), ownerRegister.get(1))
        );
    }
}
