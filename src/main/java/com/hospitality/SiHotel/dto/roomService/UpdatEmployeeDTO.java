package com.hospitality.SiHotel.dto.roomService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatEmployeeDTO {

    @NotBlank(message = "Employee number name must be filled")
    @Size(max = 20, message = "Employee number must be not longer than 20 characters")
    private String employeeNumber;

    @NotBlank(message = "First name must be filled")
    @Size(max = 50, message = "First name must be not longer than 50 characters")
    private String firstName;

    @Size(max = 50, message = "Middle name must be not longer than 50 characters")
    private String middleName;

    @Size(max = 50, message = "Last name must be not longer than 50 characters")
    private String lastName;

    @Size(max = 50, message = "Company name must be not longer than 50 characters")
    private String outsourcingCompany;

}
