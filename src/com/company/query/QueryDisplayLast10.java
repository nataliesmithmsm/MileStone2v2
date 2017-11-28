package com.company.query;

import com.company.Mongo.ConnectionToMongo;
import com.company.Mongo.ConvertingBsonToJava;
import com.company.dataobjects.PersonalDetails;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryDisplayLast10 {

    public List <PersonalDetails>  displayLast10Profiles() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<PersonalDetails> display10List = new ArrayList<>(); //new list to store items

        MongoCollection<BasicDBObject> allProfiles = ConnectionToMongo.connection();  //returns collection
        MongoCursor<BasicDBObject> cursor = allProfiles.find().sort(new BasicDBObject("$natural", -1)).limit(10).iterator();    //sorts list in descending order and reads first 10 items

        while (cursor.hasNext())
        {
            String last10items = cursor.next().toString();

            mapper.readValue(last10items, PersonalDetails.class);

            System.out.println(last10items);
        }

        return display10List;

    }
}
