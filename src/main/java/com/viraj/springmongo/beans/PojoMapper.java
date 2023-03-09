package com.viraj.springmongo.beans;

import com.viraj.springmongo.beans.dtos.VehicleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PojoMapper {
  PojoMapper MAPPER = Mappers.getMapper(PojoMapper.class);

  Vehicle convertToVehicle(VehicleRequest request);
}
