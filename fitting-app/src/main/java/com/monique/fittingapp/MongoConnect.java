package com.monique.fittingapp;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;

public class MongoConnect {
    public static void main(String args [] ) throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoCredential credential;
        credential = MongoCredential.createMongoCRCredential("mjones", "fitapp", "password".toCharArray());

        System.out.println("Connected to the database successfully");

        MongoDatabase database = (MongoDatabase) mongo.getDB("fitapp");
        System.out.println("Credentials ::"+ credential);
    }
}
