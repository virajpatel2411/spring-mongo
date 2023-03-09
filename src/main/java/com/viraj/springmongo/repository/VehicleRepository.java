package com.viraj.springmongo.repository;

import com.viraj.springmongo.beans.Vehicle;

public interface VehicleRepository {
  Vehicle fetchById(String id);

  Vehicle updateVehicle(String id, Vehicle vehicleToUpdate);

  Vehicle save(Vehicle vehicle);

  long deleteVehicle(String id);
}
