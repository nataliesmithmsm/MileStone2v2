package com.company.query;

import com.company.Mongo.ConnectionToMongo;
import com.company.dataobjects.PersonalDetails;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryPrintAll {

    public List<PersonalDetails> printAllDocuments() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List <PersonalDetails> profileList = new ArrayList<>();

        MongoCollection<BasicDBObject> allProfiles = ConnectionToMongo.connection();
        MongoCursor<BasicDBObject> cursor = allProfiles.find().iterator();

        while (cursor.hasNext()) {
            String profiles = cursor.next().toString();
            profileList.add(getAllProfiles(mapper, profiles.toString()));

            System.out.println(profiles);
        }

        return profileList;
    }

    private PersonalDetails getAllProfiles(ObjectMapper mapper, String profiles) throws IOException {
        return mapper.readValue(profiles, PersonalDetails.class);
    }

}
