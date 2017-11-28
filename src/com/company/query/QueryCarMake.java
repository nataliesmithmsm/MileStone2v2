package com.company.query;

import com.company.Mongo.ConnectionToMongo;
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

        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        MongoCollection<BasicDBObject> allProfiles = ConnectionToMongo.connection();
        MongoCursor<BasicDBObject> personsWithBMWCar = findPersonsWithBMWCar(allProfiles);

        while (personsWithBMWCar.hasNext()) {
            String personWithBMW = personsWithBMWCar.next().toString();
            personsWithBMW.add(getPersonWithBMW(mapper, personWithBMW));

            System.out.println(personWithBMW); //Delete After Test
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
        return (BasicDBObject) new BasicDBObjectBuilder().add("CarDetails.CarMake", "BMW").get();
    }

}