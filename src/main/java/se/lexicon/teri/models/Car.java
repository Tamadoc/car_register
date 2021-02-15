package se.lexicon.teri.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Car implements Serializable {

    public UUID carId;
    public String regNumber;
    public String brand;
    public String model;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public LocalDate regDate;
    public Owner owner;

    Car() {
        carId = UUID.randomUUID();
    }

    public Car(String regNumber, String brand, String model, LocalDate regDate, Owner owner) {
        this();
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.regDate = regDate;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", regDate=" + regDate +
                ", owner=" + owner.toString() +
                '}';
    }
}
