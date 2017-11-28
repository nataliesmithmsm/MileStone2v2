package com.company.query;

import com.company.Mongo.ConnectionToMongo;
import com.company.Mongo.ConvertingBsonToJava;
import com.company.dataobjects.PersonalDetails;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QueryPostCodes {

    public List<PersonalDetails> searchForPostcodes() throws IOException {
        List<PersonalDetails> profilesWithSK11Postcodes = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        MongoCollection<BasicDBObject> allProfiles = ConnectionToMongo.connection();  //returns collection
        MongoCursor<BasicDBObject> cursor = findProfilesWithSK11(allProfiles);

        while (cursor.hasNext()) {
            String profilesWithSK11 = cursor.next().toString();
            profilesWithSK11Postcodes.add(getProfilesWithSK11(mapper, profilesWithSK11.toString()));

            System.out.println(profilesWithSK11);
        }
        return profilesWithSK11Postcodes;
    }


    private PersonalDetails getProfilesWithSK11(ObjectMapper mapper, String profileWithSK11) throws IOException {
        return mapper.readValue(profileWithSK11, PersonalDetails.class);
    }

    private MongoCursor<BasicDBObject> findProfilesWithSK11(MongoCollection<BasicDBObject> personDetails)
    {
        return personDetails.find(filterByPostcode()).iterator();
    }

    private BasicDBObject filterByPostcode()
    {
        //Query
        //BasicDBObject query = new BasicDBObject();
        String pattern1 = ".*" + "SK11" + ".*";
        Pattern stringPattern = Pattern.compile(pattern1);
        return (BasicDBObject) new BasicDBObjectBuilder().add("Address.PostCode", stringPattern).get();
    }




}
