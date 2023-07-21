package com.hospitality.SiHotel.service;

import com.hospitality.SiHotel.dto.inventory.InsertInventoryDTO;
import com.hospitality.SiHotel.dto.inventory.InventoryRowDTO;
import com.hospitality.SiHotel.dto.inventory.UpdateInventoryDTO;
import com.hospitality.SiHotel.dto.room.*;
import com.hospitality.SiHotel.entity.Inventory;
import com.hospitality.SiHotel.entity.Room;
import com.hospitality.SiHotel.entity.RoomInventory;
import com.hospitality.SiHotel.enumeration.RoomType;
import com.hospitality.SiHotel.repository.InventoryRepository;
import com.hospitality.SiHotel.repository.RoomInventoryRepository;
import com.hospitality.SiHotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomInventoryRepository roomInventoryRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    private final Integer rowPerPage = 10;

    public Page<RoomRowDTO> getTable(String number, String type, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowPerPage);
        return roomRepository.getTable(number, type, pageable);
    }

    public Room save(InsertRoomDTO dto){
        var entity = new Room(
                dto.getNumber(),
                dto.getFloor(),
                dto.getType(),
                dto.getGuestLimit(),
                dto.getCost(),
                dto.getDescription()
        );
        return roomRepository.save(entity);
    }

    public Room save(UpdateRoomDTO dto){
        var entity = new Room(
                dto.getNumber(),
                dto.getFloor(),
                dto.getType(),
                dto.getGuestLimit(),
                dto.getCost(),
                dto.getDescription()
        );
        return roomRepository.save(entity);
    }

    public UpdateRoomDTO findById(String number){
        var entity = roomRepository.findById(number).get();
        return new UpdateRoomDTO(
                entity.getNumber(),
                entity.getFloor(),
                RoomType.valueOf(entity.getType()),
                entity.getGuestLimit(),
                entity.getCost(),
                entity.getDescription()
        );
    }

    public void delete(String number){
        roomRepository.deleteById(number);
    }


    public Page<RoomInventoryRowDTO> getTable(String number, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowPerPage);
        return roomInventoryRepository.getTable(number, pageable);
    }

    public RoomRowDTO getRoomHeader(String number){
        var entity = roomRepository.findById(number).get();
        return new RoomRowDTO(
                entity.getNumber(),
                entity.getFloor(),
                RoomType.valueOf(entity.getType()).getLabel(),
                entity.getGuestLimit()
        );
    }

    public List<String> getInventoryDropdown(){
        return inventoryRepository.getDropdown();
    }

    public RoomInventory save(InsertItemDTO dto){
        var entity = new RoomInventory(
                null,
                dto.getRoomNumber(),
                dto.getInventoryName(),
                dto.getQuantity()
        );
        return roomInventoryRepository.save(entity);
    }

    public void removeItem(Long id){
        roomInventoryRepository.deleteById(id);
    }

}
