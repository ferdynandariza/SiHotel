package com.hospitality.SiHotel.service;

import com.hospitality.SiHotel.dto.reservationLog.ReservationRowDTO;
import com.hospitality.SiHotel.dto.roomService.EmployeeRowDTO;
import com.hospitality.SiHotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservationLogService {

    @Autowired
    ReservationRepository reservationRepository;

    private final Integer rowPerPage = 10;

    public Page<ReservationRowDTO> getTable(String roomNumber, String guestUsername, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowPerPage);
        return reservationRepository.getTable(roomNumber, guestUsername, pageable);
    }


}
