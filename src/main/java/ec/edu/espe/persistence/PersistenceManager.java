/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.persistence;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

/**
 *
 * @author Freddy
 */
public final class PersistenceManager {

    private  static final PersistenceManager INSTANCE = new PersistenceManager();
    private static Morphia morphia;
    private static MongoClient mongoClient;
    private final Datastore mds;
    public static final String DB_NAME = "xmatch";
    public static final String DB_PACKAGE = "ec.edu.espe.model";

    public PersistenceManager() {
        MongoClientOptions mongoOptions
                = MongoClientOptions.builder().socketTimeout(60000).connectTimeout(60000).build();

        try {

            //mongoClient = new MongoClient(new ServerAddress("ds038739.mlab.com:38739"), mongoOptions);
            String textUri = "mongodb://xmatch:xmatch@ds038739.mlab.com:38739/xmatch";
            MongoClientURI uri = new MongoClientURI(textUri);
            mongoClient = new MongoClient(uri);
        } catch (Exception e) {

            throw new RuntimeException("Error", e);
        }

        mongoClient.setWriteConcern(WriteConcern.SAFE);
        mongoClient.setReadPreference(ReadPreference.primary());
        morphia = new Morphia();

        morphia.mapPackage(DB_PACKAGE, true);
        mds = morphia.createDatastore(mongoClient, DB_NAME);
        mds.ensureIndexes();
    }

    public Datastore datastore() {
        return this.mds;
    }

    public static PersistenceManager instance() {

        return INSTANCE;

    }
}
