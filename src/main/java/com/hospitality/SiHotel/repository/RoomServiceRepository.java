package com.hospitality.SiHotel.repository;

import com.hospitality.SiHotel.dto.roomService.EmployeeRowDTO;
import com.hospitality.SiHotel.entity.RoomServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomServiceRepository extends JpaRepository<RoomServiceEntity, String> {

    @Query("""
            SELECT new com.hospitality.SiHotel.dto.roomService.EmployeeRowDTO(
                rs.employeeNumber,
                CONCAT(rs.firstName, ' ', COALESCE(rs.middleName, ''), ' ', COALESCE(rs.lastName, '')),
                rs.outsourcingCompany 
            )
            FROM RoomServiceEntity AS rs
            WHERE (rs.employeeNumber LIKE %:number% OR :number IS NULL)
                AND (rs.firstName LIKE %:name% OR rs.middleName LIKE %:name%  OR rs.lastName LIKE %:name% OR :name IS NULL)
            """)
    public Page<EmployeeRowDTO> getTable(@Param("number") String number,
                                         @Param("name") String name,
                                         Pageable pageable);


}
