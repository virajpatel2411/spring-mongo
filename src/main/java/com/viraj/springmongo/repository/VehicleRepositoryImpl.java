package com.viraj.springmongo.repository;

import com.viraj.springmongo.beans.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static com.viraj.springmongo.utils.Constants._ID;

@Repository
@RequiredArgsConstructor
public class VehicleRepositoryImpl implements VehicleRepository {
  private final MongoTemplate mongoTemplate;

  @Override
  public Vehicle fetchById(String id) {
    return mongoTemplate.findById(id, Vehicle.class);
  }

  @Override
  public Vehicle updateVehicle(String id, Vehicle vehicleToUpdate) {
    Criteria criteria = Criteria.where(_ID).is(id);
    return mongoTemplate.findAndReplace(
        Query.query(criteria), vehicleToUpdate, FindAndReplaceOptions.options().returnNew());
  }

  @Override
  public Vehicle save(Vehicle vehicle) {
    return mongoTemplate.save(vehicle);
  }

  @Override
  public long deleteVehicle(String id) {
    Criteria criteria = Criteria.where(_ID).is(id);
    return mongoTemplate.remove(Query.query(criteria), Vehicle.class).getDeletedCount();
  }
}
