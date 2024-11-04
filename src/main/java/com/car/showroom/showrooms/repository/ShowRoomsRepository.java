package com.car.showroom.showrooms.repository;

import com.car.showroom.showrooms.entity.ShowRooms;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ShowRoomsRepository extends JpaRepository<ShowRooms, UUID> {
    Page<ShowRooms> findByDeletedFalse(Pageable pageable);
    @Query("select s from ShowRooms s where s.commercialRegistrationNumber =:commercialNumber and s.deleted = false ")
   Optional <ShowRooms> findByCommercialRegistrationNumber(long commercialNumber);
}

