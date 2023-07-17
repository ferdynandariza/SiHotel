package com.hospitality.SiHotel.dto.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomRowDTO {

    private String number;

    private Integer floor;

    private String type;

    private Integer guestLimit;

    private Double costPerDay;

    private String status;

}
