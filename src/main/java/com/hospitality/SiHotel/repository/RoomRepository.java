package com.hospitality.SiHotel.repository;

import com.hospitality.SiHotel.dto.room.RoomRowDTO;
import com.hospitality.SiHotel.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("""
            SELECT new com.hospitality.SiHotel.dto.room.RoomRowDTO(
                r.number,
                r.floor,
                r.type,
                r.guestLimit,
                r.cost,
                ''
            )
            FROM Room AS r
            WHERE (r.number LIKE %:number% OR :number IS NULL)
                AND (r.type = :type OR :type IS NULL OR :type = '')
            """)
    public Page<RoomRowDTO> getTable(@Param("number") String number,
                                     @Param("type") String type,
                                     Pageable pageable);

}
