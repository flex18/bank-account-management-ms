package com.nttdata.bank.account.management.ms.configuration.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClients;
import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.nttdata.bank.account.management.ms.repository")
public class MongoConnection extends AbstractReactiveMongoConfiguration{

    @Autowired
    MongoProperties mongoProperties;
    
	@Override
	protected String getDatabaseName() {
		return mongoProperties.getDb();
	}
	
	public com.mongodb.reactivestreams.client.MongoClient mongoClient(){
        String conn = "mongodb://" + mongoProperties.getUser() + ":" + mongoProperties.getPasswd() + "@"
                + mongoProperties.getUrl() + "/" + mongoProperties.getDb() + "?authSource=" + mongoProperties.getDb();
        ConnectionString connectionString = new ConnectionString(conn);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);		
	}
	
    @Override
    public Collection<String> getMappingBasePackages() {
       return Collections.singleton("com.nttdata.bank.account.management.ms");
    }
    
    
}
