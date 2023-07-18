package com.hospitality.SiHotel.dto.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomInventoryRowDTO {

    private Long id;

    private String inventory;

    private Integer stock;

    private Integer quantity;

}
