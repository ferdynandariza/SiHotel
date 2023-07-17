package com.hospitality.SiHotel.service;

import com.hospitality.SiHotel.dto.inventory.InsertInventoryDTO;
import com.hospitality.SiHotel.dto.inventory.InventoryRowDTO;
import com.hospitality.SiHotel.dto.inventory.UpdateInventoryDTO;
import com.hospitality.SiHotel.entity.Inventory;
import com.hospitality.SiHotel.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    private final Integer rowPerPage = 10;

    public Page<InventoryRowDTO> getTable(Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowPerPage);
        return inventoryRepository.getTable(pageable);
    }

    public Inventory save(InsertInventoryDTO dto){
        var entity = new Inventory(
                dto.getName(),
                dto.getDescription(),
                dto.getStock()
        );
        return inventoryRepository.save(entity);
    }

    public Inventory save(UpdateInventoryDTO dto){
        var entity = new Inventory(
                dto.getName(),
                dto.getDescription(),
                dto.getStock()
        );
        return inventoryRepository.save(entity);
    }

    public UpdateInventoryDTO findById(String name){
        var entity = inventoryRepository.findById(name).get();
        return new UpdateInventoryDTO(
                entity.getName(),
                entity.getDescription(),
                entity.getStock()
        );
    }

    public void delete(String name){
        inventoryRepository.deleteById(name);
    }

}
