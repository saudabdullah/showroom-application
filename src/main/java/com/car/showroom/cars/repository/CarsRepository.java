package com.car.showroom.cars.repository;

import com.car.showroom.cars.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CarsRepository extends JpaRepository<Cars, UUID>, JpaSpecificationExecutor<Cars> {
}
