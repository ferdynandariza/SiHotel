package com.hospitality.SiHotel.dto.inventory;

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
public class UpdateInventoryDTO {

    @NotBlank(message = "Inventory name must be filled")
    @Size(max = 50, message = "Inventory name must be not longer than 50 characters")
    private String name;

    @Size(max = 500, message = "Description must be not longer than 500 characters")
    private String description;

    @NotNull(message = "Stock number must be filled")
    private Integer stock;
}
