package com.viraj.springmongo.configurations.launcher;

import com.viraj.springmongo.BasePackageMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
@ComponentScan(basePackageClasses = BasePackageMarker.class)
public class SpringMongoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMongoApplication.class, args);
  }
}
