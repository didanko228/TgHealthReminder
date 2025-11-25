package com.didanko228.tghealthreminder.utils;

import com.didanko228.tghealthreminder.Main;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDriver {
    public static Document getOrCreateUser(long user_id) {
        try (MongoClient mongoClient = MongoClients.create(Config.MONGODB_URL)) {
            MongoDatabase database = mongoClient.getDatabase(Main.PROJECT_ID);
            MongoCollection<Document> collection = database.getCollection("users");

            Document found = collection.find(new Document("id", user_id)).first();

            if (found == null) {
                Document doc = new Document("id", user_id)
                        .append("language", TranslationManager.DEFAULT_LANGUAGE);

                collection.insertOne(doc);
                mongoClient.close();
                Logger.info("User not exists in database. Written.");

                return doc;
            } else {
                return found;
            }
        }
    }
}
