package com.viraj.springmongo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Vehicle")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
  @Id private String id;
  private String make;
  private String model;
  private String name;
  private double weight;
  private double maxSpeed;
}
