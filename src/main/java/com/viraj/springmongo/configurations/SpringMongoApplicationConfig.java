package com.viraj.springmongo.configurations;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class SpringMongoApplicationConfig {

  @Bean
  public MongoTemplate mongoTemplate() {
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    return new MongoTemplate(mongoClient, "database_vehicle");
  }
}
