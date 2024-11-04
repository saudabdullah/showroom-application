package com.car.showroom.cars.components;

import com.car.showroom.cars.entity.Cars;
import com.car.showroom.showrooms.entity.ShowRooms;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CarSpecification {


    public static Specification<Cars> hasMaker(String maker) {
        return (root, query, criteriaBuilder) ->
                maker == null ? null : criteriaBuilder.equal(root.get("maker"), maker);
    }
    public static Specification<Cars> hasVin(String vin) {
        return (root, query, criteriaBuilder) ->
                vin == null ? null : criteriaBuilder.equal(root.get("vin"), vin);
    }

    public static Specification<Cars> hasShowroomName(String showroomName) {
        return (root, query, criteriaBuilder) -> {
            if (showroomName == null) return null;
            Join<Cars, ShowRooms> showRoom = root.join("showRoom");
            return criteriaBuilder.equal(showRoom.get("name"), showroomName);
        };
    }

    public static Specification<Cars> hasModel(String model) {
        return (root, query, criteriaBuilder) ->
                model == null ? null : criteriaBuilder.equal(root.get("model"), model);
    }

    public static Specification<Cars> hasModelYear(int modelYear) {
        return (root, query, criteriaBuilder) ->
                modelYear == 0 ? null : criteriaBuilder.equal(root.get("modelYear"), modelYear);
    }
    public static Specification<Cars> hasPrice(double modelYear) {
        return (root, query, criteriaBuilder) ->
                modelYear == 0 ? null : criteriaBuilder.equal(root.get("modelYear"), modelYear);
    }

}
