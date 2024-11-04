package com.car.showroom.showrooms.entity;

import com.car.showroom.cars.entity.Cars;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "tbl_showroom")
public class ShowRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "commercial_registration_number")
    private long commercialRegistrationNumber;

    @Column(name = "manger_name")
    private String mangerName;

    @Column(name = "contact_number")
    private long contactNumber;

    @Column(name = "address")
    private String address;
    @Column(name = "deleted")
    private boolean deleted = false;
    @OneToMany(mappedBy = "showRoom")
    private List<Cars> cars;

}
