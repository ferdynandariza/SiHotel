package com.hospitality.SiHotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "RoomInventories")
public class RoomInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "RoomNumber")
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "RoomNumber", insertable = false, updatable = false)
    private Room room;

    @Column(name = "InventoryName")
    private String inventoryName;

    @ManyToOne
    @JoinColumn(name = "InventoryName", insertable = false, updatable = false)
    private Inventory inventory;

    @Column(name = "Quantity")
    private Integer quantity;

    public RoomInventory(Long id, String roomNumber, String inventoryName, Integer quantity) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.inventoryName = inventoryName;
        this.quantity = quantity;
    }
}
