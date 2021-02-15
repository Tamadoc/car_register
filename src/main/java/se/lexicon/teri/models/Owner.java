package se.lexicon.teri.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Owner implements Serializable {

    public UUID ownerID;
    public String name;
    public LocalDate birthdate;

    Owner() {
        ownerID = UUID.randomUUID();
    }

    public Owner(String name, LocalDate birthdate) {
        this();
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
