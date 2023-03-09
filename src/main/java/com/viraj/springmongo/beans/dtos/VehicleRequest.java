package com.viraj.springmongo.beans.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {
  @NotBlank private String make;
  @NotBlank private String model;
  @NotBlank private String name;
  @NotNull private Double weight;
  @NotNull private Double maxSpeed;
}
