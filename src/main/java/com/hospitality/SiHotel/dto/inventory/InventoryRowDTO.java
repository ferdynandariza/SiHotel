package com.hospitality.SiHotel.dto.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRowDTO {

    private String name;

    private String description;

    private Integer stock;

}
