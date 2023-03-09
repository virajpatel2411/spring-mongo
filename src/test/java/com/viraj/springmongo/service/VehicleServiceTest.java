package com.viraj.springmongo.service;

import com.viraj.springmongo.beans.dtos.VehicleRequest;
import com.viraj.springmongo.exceptions.EntityNotFoundException;
import com.viraj.springmongo.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {
  private VehicleService vehicleService;
  private VehicleRepository mockVehicleRepo;

  @BeforeEach
  public void setUp() throws Exception {
    mockVehicleRepo = mock(VehicleRepository.class);
    vehicleService = new VehicleServiceImpl(mockVehicleRepo);
  }

  @Test
  public void fetchById_EntityNotFoundException() {
    when(mockVehicleRepo.fetchById(any())).thenReturn(null);
    Assertions.assertThrows(
        EntityNotFoundException.class, () -> vehicleService.fetchVehicle("random"));
  }

  @Test
  public void updateVehicle_EntityNotFoundException() {
    when(mockVehicleRepo.fetchById(any())).thenReturn(null);
    Assertions.assertThrows(
        EntityNotFoundException.class,
        () -> vehicleService.updateVehicle("random", new VehicleRequest()));
  }
}
