package com.viraj.springmongo.service;

import com.viraj.springmongo.beans.Vehicle;
import com.viraj.springmongo.beans.dtos.VehicleRequest;
import com.viraj.springmongo.exceptions.EntityNotFoundException;
import com.viraj.springmongo.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.viraj.springmongo.beans.PojoMapper.MAPPER;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService {
  private final VehicleRepository vehicleRepository;

  @Override
  public Vehicle addVehicle(VehicleRequest vehicleRequest) {
    Vehicle vehicle = MAPPER.convertToVehicle(vehicleRequest);
    vehicle.setId(UUID.randomUUID().toString());
    return vehicleRepository.save(vehicle);
  }

  @Override
  public Vehicle updateVehicle(String id, VehicleRequest vehicleRequest) {
    Vehicle vehicle = vehicleRepository.fetchById(id);
    if (isNull(vehicle)) {
      throw new EntityNotFoundException(id);
    }
    Vehicle vehicleToUpdate = MAPPER.convertToVehicle(vehicleRequest);
    vehicle.setId(id);
    return vehicleRepository.updateVehicle(id, vehicleToUpdate);
  }

  @Override
  public Vehicle fetchVehicle(String id) {
    Vehicle vehicle = vehicleRepository.fetchById(id);
    if (isNull(vehicle)) {
      throw new EntityNotFoundException(id);
    }
    return vehicle;
  }

  @Override
  public long deleteVehicle(String id) {
    return vehicleRepository.deleteVehicle(id);
  }
}
