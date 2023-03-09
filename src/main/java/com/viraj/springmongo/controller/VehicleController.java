package com.viraj.springmongo.controller;

import com.viraj.springmongo.beans.dtos.VehicleRequest;
import com.viraj.springmongo.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.viraj.springmongo.utils.Constants.DATA;
import static com.viraj.springmongo.utils.Constants.STATUS;
import static com.viraj.springmongo.utils.Constants.SUCCESS;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {
  private final VehicleService vehicleService;

  @PostMapping
  public ResponseEntity<Map<String, Object>> addVehicle(
      @RequestBody @Valid VehicleRequest vehicleRequest) {
    return okResponseEntity(vehicleService.addVehicle(vehicleRequest));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, Object>> updateVehicle(
      @PathVariable("id") String id, @RequestBody @Valid VehicleRequest vehicleRequest) {
    return okResponseEntity(vehicleService.updateVehicle(id, vehicleRequest));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> fetchVehicle(@PathVariable("id") String id) {
    return okResponseEntity(vehicleService.fetchVehicle(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Object>> deleteVehicle(@PathVariable("id") String id) {
    return okResponseEntity(vehicleService.deleteVehicle(id));
  }

  private static <T> ResponseEntity<Map<String, Object>> okResponseEntity(T data) {
    Map<String, Object> response = new HashMap<>();
    response.put(STATUS, SUCCESS);
    response.put(DATA, data);
    return ResponseEntity.ok(response);
  }
}
