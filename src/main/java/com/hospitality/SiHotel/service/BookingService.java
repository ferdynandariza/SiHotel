package com.hospitality.SiHotel.service;

import com.hospitality.SiHotel.dto.booking.ReservationDTO;
import com.hospitality.SiHotel.dto.booking.RoomDetailDTO;
import com.hospitality.SiHotel.dto.room.RoomRowDTO;
import com.hospitality.SiHotel.entity.Reservation;
import com.hospitality.SiHotel.enumeration.RoomType;
import com.hospitality.SiHotel.repository.ReservationRepository;
import com.hospitality.SiHotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class BookingService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    private final Integer rowPerPage = 10;

    public Page<RoomRowDTO> getTable(String number, String type, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowPerPage);
        var table = roomRepository.getTable(number, type, pageable);
        table.forEach(entity -> entity.setStatus(getRoomStatus(entity.getNumber())));
        return table;
    }

    private String getRoomStatus(String number){
        Integer counted = reservationRepository.countRoomReservation(number, LocalDateTime.now());
        return counted > 0 ? "Unavailable" : "Available";
    }

    public RoomDetailDTO getDetail(String number){
        var entity = roomRepository.findById(number).get();
        return new RoomDetailDTO(
                entity.getNumber(),
                entity.getFloor(),
                RoomType.valueOf(entity.getType()).getLabel(),
                entity.getGuestLimit(),
                entity.getCost(),
                entity.getDescription()
        );
    }

    private String generateCode(String roomNumber){
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        var stringDate = formatter.format(LocalDate.now());
        var todayStart = LocalDate.now().atStartOfDay();
        var todayEnd = LocalDate.now().atTime(LocalTime.of(23, 59));
        var rollingNumber = reservationRepository.getRollingNumber(todayStart, todayEnd) + 1;
        var code = String.format("%s-%s-%03d", roomNumber, stringDate, rollingNumber);
        return code;
    }

    private Double getTotalCost(ReservationDTO dto){
        Long days = ChronoUnit.DAYS.between(dto.getCheckIn(), dto.getCheckOut());
        days = days > 0L ? days : 1L;
        var room = roomRepository.findById(dto.getRoomNumber()).get();
        var totalCost = room.getCost() * days.doubleValue();
        return totalCost;
    }
    public Reservation makeReservation(ReservationDTO dto){
        var roomNumber = dto.getRoomNumber();
        var entity = new Reservation(
                generateCode(roomNumber),
                "OW",
                roomNumber,
                dto.getGuestUsername(),
                LocalDateTime.now(),
                dto.getCheckIn(),
                dto.getCheckOut(),
                getTotalCost(dto),
                LocalDateTime.now(),
                dto.getPaymentMethod(),
                dto.getRemark()
        );
        return reservationRepository.save(entity);
    }



}
