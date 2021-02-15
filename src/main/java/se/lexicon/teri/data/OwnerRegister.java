package se.lexicon.teri.data;

import se.lexicon.teri.models.Owner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class OwnerRegister {

    public static List<Owner> getOwnerRegister() {
        return Arrays.asList(
                new Owner("Teri Sandstedt", LocalDate.parse("1975-04-20")),
                new Owner("Andreas Sandstedt", LocalDate.parse("1976-11-06")));
    }

    public static void listToJson(List<Owner> owners) {

    }
}
