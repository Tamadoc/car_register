package se.lexicon.teri;


import se.lexicon.teri.data.CarRegister;
import se.lexicon.teri.data.OwnerRegister;
import se.lexicon.teri.models.Car;
import se.lexicon.teri.models.Owner;
import se.lexicon.teri.util.JsonIOUtil;

import java.io.File;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Car> carRegister = CarRegister.getCarRegister();
        List<Owner> ownerRegister = OwnerRegister.getOwnerRegister();
        JsonIOUtil util = new JsonIOUtil();

        // Serialize carRegister to JSON
        File carFile = new File("cars.json");
        util.serializeListToJson(carRegister, carFile);

        // Deserialize cars.json to a duplicate list
        List<Car> duplicateCarRegister = util.deserializeJsonToCarList(carFile);
        System.out.println("Original list (first car) : " + carRegister.get(0).toString());
        System.out.println("Duplicate list (first car): " + duplicateCarRegister.get(0).toString());

        System.out.println("============================");

        // Serialize ownerRegister to JSON
        File ownerFile = new File("owners.json");
        util.serializeListToJson(ownerRegister, ownerFile);

        // Deserialize owners.json to a duplicate list
        List<Owner> duplicateOwnerRegister = util.deserializeJsonToOwnerList(ownerFile);
        System.out.println("Original list (first owner) : " + ownerRegister.get(0).toString());
        System.out.println("Duplicate list (first owner): " + duplicateOwnerRegister.get(0).toString());
    }
}
