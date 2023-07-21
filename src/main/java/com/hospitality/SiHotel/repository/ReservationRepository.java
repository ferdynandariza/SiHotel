package com.hospitality.SiHotel.repository;

import com.hospitality.SiHotel.dto.reservationLog.ReservationRowDTO;
import com.hospitality.SiHotel.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query("""
            SELECT COUNT(r.code)
            FROM Reservation AS r
            WHERE r.bookDate > :todayStart AND r.bookDate < :todayEnd
            """)
    public Integer getRollingNumber(LocalDateTime todayStart, LocalDateTime todayEnd);

    @Query("""
            SELECT COUNT(r.code)
            FROM Reservation AS r
            WHERE r.roomNumber = :roomNumber 
                AND (r.checkIn < :currentTime AND r.checkOut > :currentTime)
            """)
    public Integer countRoomReservation(String roomNumber, LocalDateTime currentTime);

    @Query("""
            SELECT new com.hospitality.SiHotel.dto.reservationLog.ReservationRowDTO(
                r.code,
                r.roomNumber,
                r.guestUsername,
                r.bookDate,
                r.checkIn,
                r.checkOut,
                r.paymentDate
            )
            FROM Reservation AS r
            WHERE (r.roomNumber LIKE %:roomNumber% OR :roomNumber IS NULL)
                AND (r.guestUsername LIKE %:guestUsername% OR :guestUsername IS NULL)
            """)
    public Page<ReservationRowDTO> getTable(@Param("roomNumber") String roomNumber,
                                            @Param("guestUsername") String guestUsername,
                                            Pageable pageable);

}
