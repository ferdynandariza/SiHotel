package com.hospitality.SiHotel.entity;

import com.hospitality.SiHotel.enumeration.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "Rooms")
public class Room {

    @Id
    @Column(name = "Number")
    private String number;

    @Column(name = "Floor", nullable = false)
    private Integer floor;

    @Column(name = "Type", nullable = false)
    private String type;

    @Column(name = "GusetLimit", nullable = false)
    private Integer guestLimit;

    @Column(name = "Cost", nullable = false)
    private Double cost;

    @Column(name = "Description")
    private String description;

    public Room(String number,
                Integer floor,
                RoomType type,
                Integer guestLimit,
                Double cost,
                String description) {
        this.number = number;
        this.floor = floor;
        this.type = type.toString();
        this.guestLimit = guestLimit;
        this.cost = cost;
        this.description = description;
    }
}
