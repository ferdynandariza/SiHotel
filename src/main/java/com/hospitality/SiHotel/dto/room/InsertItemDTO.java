package com.hospitality.SiHotel.dto.room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertItemDTO {

    @NotBlank(message = "Room number must be filled")
    @Size(max = 10, message = "Room number must be not longer than 10 characters")
    private String roomNumber;

    @NotBlank(message = "Inventory name must be filled")
    @Size(max = 50, message = "Inventory name must be not longer than 50 characters")
    private String inventoryName;

    @NotNull(message = "Quantity must be filled")
    private Integer quantity;

}
