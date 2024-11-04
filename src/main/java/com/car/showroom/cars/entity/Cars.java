package com.car.showroom.cars.entity;

import com.car.showroom.showrooms.entity.ShowRooms;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tbl_cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "maker")
    private String maker;

    @Column(name = "model")
    private String model;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "price")
    private double price;

    @Column(name = "deleted")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "showroom_id")
    private ShowRooms showRoom;
}
