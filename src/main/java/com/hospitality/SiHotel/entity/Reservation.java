package com.hospitality.SiHotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "ReservationMethod")
    private String reservationMethod;

    @Column(name = "RoomNumber")
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "RoomNumber", insertable = false, updatable = false)
    private Room room;

    @Column(name = "GuestUsername")
    private String guestUsername;

    @ManyToOne
    @JoinColumn(name = "GuestUsername", insertable = false, updatable = false)
    private Guest guest;

    @Column(name = "BookDate")
    private LocalDateTime bookDate;

    @Column(name = "CheckIn")
    private LocalDateTime checkIn;

    @Column(name = "CheckOut")
    private LocalDateTime checkOut;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "PaymentDate")
    private LocalDateTime paymentDate;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "remark")
    private String remark;

    public Reservation(String code,
                       String reservationMethod,
                       String roomNumber,
                       String guestUsername,
                       LocalDateTime bookDate,
                       LocalDateTime checkIn,
                       LocalDateTime checkOut,
                       Double cost,
                       LocalDateTime paymentDate,
                       String paymentMethod,
                       String remark) {
        this.code = code;
        this.reservationMethod = reservationMethod;
        this.roomNumber = roomNumber;
        this.guestUsername = guestUsername;
        this.bookDate = bookDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cost = cost;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.remark = remark;
    }
}
