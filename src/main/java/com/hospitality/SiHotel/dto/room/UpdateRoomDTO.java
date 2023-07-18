package com.hospitality.SiHotel.dto.room;

import com.hospitality.SiHotel.enumeration.RoomType;
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
public class UpdateRoomDTO {

    @NotBlank(message = "Room number must be filled")
    @Size(max = 10, message = "Room number must be not longer than 10 characters")
    private String number;

    @NotNull(message = "Floor number must be filled")
    private Integer floor;

    @NotNull(message = "Room type must be filled")
//    @Size(max = 3, message = "Room type must be not longer than 3 characters")
    private RoomType type;

    @NotNull(message = "Guest limit must be filled")
    private Integer guestLimit;

    @NotNull(message = "Cost must be filled")
    private Double cost;

    @Size(max = 1000, message = "Description must be not longer than 1000 characters")
    private String description;

}
