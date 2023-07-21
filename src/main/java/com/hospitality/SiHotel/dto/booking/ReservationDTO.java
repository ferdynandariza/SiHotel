package com.hospitality.SiHotel.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private String roomNumber;

    private String guestUsername;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private String paymentMethod;

    private String remark;

}
