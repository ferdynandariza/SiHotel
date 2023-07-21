package com.hospitality.SiHotel.service;

import com.hospitality.SiHotel.dto.room.InsertRoomDTO;
import com.hospitality.SiHotel.dto.room.RoomRowDTO;
import com.hospitality.SiHotel.dto.room.UpdateRoomDTO;
import com.hospitality.SiHotel.dto.roomService.*;
import com.hospitality.SiHotel.entity.Room;
import com.hospitality.SiHotel.entity.RoomServiceEntity;
import com.hospitality.SiHotel.enumeration.RoomType;
import com.hospitality.SiHotel.repository.RoomServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceService {

    @Autowired
    RoomServiceRepository roomServiceRepository;

    private final Integer rowPerPage = 10;

    public Page<EmployeeRowDTO> getTable(String number, String name, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowPerPage);
        return roomServiceRepository.getTable(number, name, pageable);
    }

    public RoomServiceEntity save(InsertEmployeeDTO dto){
        var entity = new RoomServiceEntity(
                dto.getEmployeeNumber(),
                dto.getFirstName(),
                dto.getMiddleName(),
                dto.getLastName(),
                dto.getOutsourcingCompany()
        );
        return roomServiceRepository.save(entity);
    }

    public RoomServiceEntity save(UpdatEmployeeDTO dto){
        var entity = roomServiceRepository.findById(dto.getEmployeeNumber()).get();
        entity.setFirstName(dto.getEmployeeNumber());
        entity.setMiddleName(dto.getFirstName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setLastName(dto.getLastName());
        entity.setOutsourcingCompany(dto.getOutsourcingCompany());
        return roomServiceRepository.save(entity);
    }

    public UpdatEmployeeDTO findById(String employeeNumber){
        var entity = roomServiceRepository.findById(employeeNumber).get();
        return new UpdatEmployeeDTO(
                entity.getEmployeeNumber(),
                entity.getFirstName(),
                entity.getMiddleName(),
                entity.getLastName(),
                entity.getOutsourcingCompany()
        );
    }

    public void delete(String employeNumber){
        roomServiceRepository.deleteById(employeNumber);
    }

    public EmployeeRowDTO getHeader(String employeeNumber){
        var entity = roomServiceRepository.findById(employeeNumber).get();
        return new EmployeeRowDTO(
                entity.getEmployeeNumber(),
                String.format( "%s %s %s",
                        entity.getFirstName(),
                        entity.getMiddleName(),
                        entity.getLastName()
                ),
                entity.getOutsourcingCompany()
        );
    }
    public RosterDTO getRoster(String employeeNumber){
        var entity = roomServiceRepository.findById(employeeNumber).get();
        return new RosterDTO(
                entity.getMondayRosterStart(),
                entity.getMondayRosterFinish(),
                entity.getTuesdayRosterStart(),
                entity.getTuesdayRosterFinish(),
                entity.getWednesdayRosterStart(),
                entity.getWednesdayRosterFinish(),
                entity.getThursdayRosterFinish(),
                entity.getThursdayRosterFinish(),
                entity.getFridayRosterStart(),
                entity.getFridayRosterFinish(),
                entity.getSaturdayRosterStart(),
                entity.getSaturdayRosterFinish(),
                entity.getSundayRosterStart(),
                entity.getSundayRosterFinish()
        );
    }

    public void saveRoster(UpsertRosterDTO dto){
        var entity = roomServiceRepository.findById(dto.getEmployeeNumber()).get();
        var updated = new RoomServiceEntity(
                entity.getEmployeeNumber(),
                entity.getFirstName(),
                entity.getMiddleName(),
                entity.getLastName(),
                entity.getOutsourcingCompany(),
                dto.getMondayRosterStart(),
                dto.getMondayRosterFinish(),
                dto.getTuesdayRosterStart(),
                dto.getTuesdayRosterFinish(),
                dto.getWednesdayRosterStart(),
                dto.getWednesdayRosterFinish(),
                dto.getThursdayRosterStart(),
                dto.getThursdayRosterFinish(),
                dto.getFridayRosterStart(),
                dto.getFridayRosterFinish(),
                dto.getSaturdayRosterStart(),
                dto.getSaturdayRosterFinish(),
                dto.getSundayRosterStart(),
                dto.getSundayRosterFinish()
                );
        roomServiceRepository.save(updated);
    }

    public UpsertRosterDTO rosterById(String employeeNumber){
        var entity = roomServiceRepository.findById(employeeNumber).get();
        return new UpsertRosterDTO(
                employeeNumber,
                entity.getMondayRosterStart(),
                entity.getMondayRosterFinish(),
                entity.getTuesdayRosterStart(),
                entity.getTuesdayRosterFinish(),
                entity.getWednesdayRosterStart(),
                entity.getWednesdayRosterFinish(),
                entity.getThursdayRosterFinish(),
                entity.getThursdayRosterFinish(),
                entity.getFridayRosterStart(),
                entity.getFridayRosterFinish(),
                entity.getSaturdayRosterStart(),
                entity.getSaturdayRosterFinish(),
                entity.getSundayRosterStart(),
                entity.getSundayRosterFinish()
        );
    }
}
