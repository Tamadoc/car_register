package se.lexicon.teri.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.teri.models.Car;
import se.lexicon.teri.models.Owner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIOUtil {

    private ObjectMapper objectMapper;

    public JsonIOUtil() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    // Generic method that serializes a list of any objects
    public <T> void serializeListToJson(List<T> t, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            objectMapper.writeValue(file, t);
            System.out.println("File " + file.getPath() + " saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> deserializeJsonToCarList(File file) {
        List<Car> result = new ArrayList<>();
        try{
            result = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Owner> deserializeJsonToOwnerList(File file) {
        List<Owner> result = new ArrayList<>();
        try{
            result = objectMapper.readValue(file, new TypeReference<List<Owner>>() {});
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
