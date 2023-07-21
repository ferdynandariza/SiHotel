package com.hospitality.SiHotel.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDetailDTO {

    private String number;

    private Integer floor;

    private String type;

    private Integer guestLimit;

    private Double cost;

    private String description;
}
