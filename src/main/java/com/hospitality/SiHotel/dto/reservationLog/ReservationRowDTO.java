package com.hospitality.SiHotel.dto.reservationLog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRowDTO {

    private String code;

    private String roomNumber;

    private String guestUsername;

    private LocalDateTime bookDate;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private LocalDateTime paymentDate;
}
