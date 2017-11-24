package com.company.Mongo;

import com.company.dataobjects.PersonalDetails;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;

import java.io.IOException;

public class ConversionJackson {

//    public static PersonalDetails convertingToJava(BasicDBObject carInsuranceObject) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        DBObject dbo = (DBObject) JSON.parse(mapper.writeValueAsString(carInsuranceObject));
//
////        PersonalDetails p1 = new PersonalDetails();
////
////        BasicDBObject person1 = (BasicDBObject) JSON.parse(mapper.writeValueAsString(carInsuranceObject));
////
////        PersonalDetails person2 = mapper.convertValue(DBObject, <PersonalDetails>)
////
////        ObjectMapper objectMapper = new ObjectMapper();
////
////        String object = JSON.parse(mapper.writeValueAsString(carInsuranceObject));
//
//        ObjectReader reader = mapper.reader(PersonalDetails.class);
//
//        //JsonNode profile = reader.readValue(carInsuranceObject.toString());
//
//        String profile = reader.readValue(carInsuranceObject.toString());
//
//        System.out.println(profile);
//
//        return profile;
//    }
//
//    public convertingToJava2 (BasicDBObject carInsuranceObject) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//        String profile = mapper.writeValueAsString(PersonalDetails);
////        ObjectReader reader = mapper.reader(PersonalDetails.class);
//
//        //JsonNode profile = reader.readValue(carInsuranceObject.toString());
//
////        String profile = reader.readValue(carInsuranceObject.toString());
//
//        System.out.println(profile);
//
//        return;
//    }
}
