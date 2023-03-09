package com.viraj.springmongo.repository;

import com.viraj.springmongo.beans.Vehicle;
import com.viraj.springmongo.configurations.SpringMongoApplicationConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes = {VehicleRepositoryImpl.class, SpringMongoApplicationConfig.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VehicleRepositoryTest {

  @Autowired VehicleRepository vehicleRepository;

  @Test
  @Order(1)
  public void saveVehicleTest() {
    String id = "random_id";
    Vehicle vehicle =
        new Vehicle()
            .setId(id)
            .setMake("Honda")
            .setModel("Civic")
            .setMaxSpeed(200)
            .setWeight(1000)
            .setName("Honda Civic");
    vehicleRepository.save(vehicle);
    Assertions.assertNotNull(vehicleRepository.fetchById(id));
  }

  @Test
  @Order(2)
  public void updateVehicleTest() {
    String id = UUID.randomUUID().toString();
    Vehicle vehicle =
        new Vehicle()
            .setId(id)
            .setMake("Honda")
            .setModel("Civic")
            .setMaxSpeed(200)
            .setWeight(1000)
            .setName("Honda Civic");
    vehicleRepository.save(vehicle);
    Vehicle vehicleToUpdate =
        new Vehicle()
            .setId(id)
            .setMake("Honda")
            .setModel("City")
            .setMaxSpeed(100)
            .setWeight(1001)
            .setName("city");
    vehicleRepository.updateVehicle(id, vehicleToUpdate);
    Vehicle updatedVehicle = vehicleRepository.fetchById(id);
    Assertions.assertNotNull(updatedVehicle);
    Assertions.assertEquals(updatedVehicle.getModel(), "City");
    Assertions.assertEquals(updatedVehicle.getName(), "city");
    Assertions.assertEquals(updatedVehicle.getWeight(), 1001);
    Assertions.assertEquals(updatedVehicle.getMaxSpeed(), 100);
  }

  @Test
  @Order(3)
  public void fetchVehicleTest() {
    Vehicle vehicle = vehicleRepository.fetchById("random_id");
    Assertions.assertNotNull(vehicle);
  }

  @Test
  @Order(4)
  public void fetchVehicleTest_EntityNotPresent() {
    Vehicle vehicle = vehicleRepository.fetchById("random");
    Assertions.assertNull(vehicle);
  }

  @Test
  @Order(5)
  public void deleteVehicleTest() {
    String id = UUID.randomUUID().toString();
    Vehicle vehicle =
        new Vehicle()
            .setId(id)
            .setMake("Honda")
            .setModel("Civic")
            .setMaxSpeed(200)
            .setWeight(1000)
            .setName("Honda Civic");
    vehicleRepository.save(vehicle);
    long deleteVehicle = vehicleRepository.deleteVehicle(id);
    Assertions.assertEquals(deleteVehicle, 1);
  }

  @Test
  @Order(6)
  public void deleteVehicleTestEntityNotPresent() {
    long deleteVehicle = vehicleRepository.deleteVehicle("random");
    Assertions.assertEquals(deleteVehicle, 0);
  }
}
