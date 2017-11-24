package com.company.query;

import com.company.dataobjects.PersonalDetails;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryCarMake {

    public List<PersonalDetails> searchForCarsWithBMW() throws IOException {

        List<PersonalDetails> personsWithBMW = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        //mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        MongoCollection<BasicDBObject> allProfiles = getAllProfiles();
        MongoCursor<BasicDBObject> personsWithBMWCar = findPersonsWithBMWCar(allProfiles);

        while (personsWithBMWCar.hasNext()) {
            String personWithBMW = personsWithBMWCar.next().toString();
            personsWithBMW.add(getPersonWithBMW(mapper, personWithBMW));

            System.out.println(personsWithBMW); //Delete After Test
        }

        return personsWithBMW;
    }

    private PersonalDetails getPersonWithBMW(ObjectMapper mapper, String personWithBMW) throws IOException {
        return mapper.readValue(personWithBMW, PersonalDetails.class);
    }

    private MongoCursor<BasicDBObject> findPersonsWithBMWCar(MongoCollection<BasicDBObject> personDetails) {
        return personDetails.find(filterByBMW()).iterator();
    }

    private BasicDBObject filterByBMW() {
        return queryByCarMake();
    }

    private BasicDBObject queryByCarMake() {
        return (BasicDBObject) new BasicDBObjectBuilder().add("CarMake", "BMW").get();
    }

    private MongoCollection<BasicDBObject> getAllProfiles() {
        return getCarInsuranceDatabase().getCollection("Personal_Details", BasicDBObject.class);
    }

    private MongoDatabase getCarInsuranceDatabase() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        return mongoClient.getDatabase("Car_Insurance_Details");
    }
}