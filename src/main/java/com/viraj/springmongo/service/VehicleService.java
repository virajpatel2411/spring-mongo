package com.viraj.springmongo.service;

import com.viraj.springmongo.beans.Vehicle;
import com.viraj.springmongo.beans.dtos.VehicleRequest;

public interface VehicleService {
  Vehicle addVehicle(VehicleRequest vehicleRequest);

  Vehicle updateVehicle(String id, VehicleRequest vehicleRequest);

  Vehicle fetchVehicle(String id);

  long deleteVehicle(String id);
}
