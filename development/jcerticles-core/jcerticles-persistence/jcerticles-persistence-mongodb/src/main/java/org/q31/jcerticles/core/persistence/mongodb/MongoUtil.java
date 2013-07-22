package org.q31.jcerticles.core.persistence.mongodb;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.DatastoreImpl;
import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import org.q31.jcerticles.core.persistence.base.dao.content.IContentDAO;
import org.q31.jcerticles.core.persistence.mongodb.dao.content.impl.ContentDAOImpl;

import java.net.UnknownHostException;

/**
 * Refactor
 */
public final class MongoUtil {

    private static final int PORT = 27017;
    private static final String HOST = "localhost";
    //private static final String HOST = "127.9.74.129";
    private static final String USER = "admin";
    private static final String PASS = "92g5ve9c9_Wz";
    private static final String DATABASE_NAME = "jcerticles";
    private static Mongo mongo = null;
    private static Datastore datastore;


    private static Mongo getMongo() {
        if (mongo == null) {
            try {
                mongo = new Mongo(HOST, PORT);
                System.out.println("New Mongo created with [" + HOST + "] and ["
                        + PORT + "]");
            } catch (MongoException e){
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return mongo;
    }

    private static Morphia getMorphia(Class entityClass) {
        Morphia morphia = new Morphia();
        morphia.map(entityClass);
        return morphia;
    }

    private static Datastore createMongoDataStore(Class entityClass) {
        Morphia morphia = getMorphia(entityClass);
        datastore = !getMongo().getDB(DATABASE_NAME).isAuthenticated()? new DatastoreImpl(morphia, getMongo(), DATABASE_NAME, USER, PASS.toCharArray()) : new DatastoreImpl(morphia, getMongo(), DATABASE_NAME);

        //datastore = new Morphia().map(entityClass).createDatastore(getMongo(), DATABASE_NAME, USER, PASS.toCharArray());
        datastore.ensureIndexes();

        return datastore;
    }

    public static IContentDAO getContentDAO(Class entityClass) {
        return new ContentDAOImpl (entityClass, getMongo(), getMorphia(entityClass), "jcerticles");
        //return new ContentDAOImpl (entityClass, createMongoDataStore(entityClass));
    }
}