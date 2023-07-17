package com.hospitality.SiHotel.service;

import com.hospitality.SiHotel.dto.inventory.InventoryRowDTO;
import com.hospitality.SiHotel.dto.room.RoomRowDTO;
import com.hospitality.SiHotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    private final Integer rowPerPage = 10;

    public Page<RoomRowDTO> getTable(String number, String type, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowPerPage);
        return roomRepository.getTable(number, type, pageable);
    }


}
