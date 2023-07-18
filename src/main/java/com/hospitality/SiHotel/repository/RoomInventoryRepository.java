package com.hospitality.SiHotel.repository;

import com.hospitality.SiHotel.dto.room.RoomInventoryRowDTO;
import com.hospitality.SiHotel.entity.RoomInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomInventoryRepository extends JpaRepository<RoomInventory, Long> {

    @Query("""
            SELECT new com.hospitality.SiHotel.dto.room.RoomInventoryRowDTO(
                ri.id,
                ri.inventoryName,
                i.stock,
                ri.quantity
            )
            FROM RoomInventory AS ri
                INNER JOIN ri.inventory AS i
            WHERE ri.roomNumber = :roomNumber
            """)
    public Page<RoomInventoryRowDTO> getTable(@Param("roomNumber") String roomNumber, Pageable pageable);


}
