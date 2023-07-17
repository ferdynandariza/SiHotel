package com.hospitality.SiHotel.repository;

import com.hospitality.SiHotel.dto.inventory.InventoryRowDTO;
import com.hospitality.SiHotel.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    @Query("""
            SELECT new com.hospitality.SiHotel.dto.inventory.InventoryRowDTO(
                i.name,
                i.description,
                i.stock
            )
            FROM Inventory AS i
            """)
    public Page<InventoryRowDTO> getTable(Pageable pageable);
}
