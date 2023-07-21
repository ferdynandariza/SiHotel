package com.hospitality.SiHotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RoomServices")
public class RoomServiceEntity {

    @Id
    @Column(name = "EmployeeNumber")
    private String employeeNumber;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "OutsourcingCompany")
    private String outsourcingCompany;

    @Column(name = "MondayRosterStart")
    private LocalTime mondayRosterStart;

    @Column(name = "MondayRosterFinish")
    private LocalTime mondayRosterFinish;

    @Column(name = "TuesdayRosterStart")
    private LocalTime tuesdayRosterStart;

    @Column(name = "TuesdayRosterFinish")
    private LocalTime tuesdayRosterFinish;

    @Column(name = "WednesdayRosterStart")
    private LocalTime wednesdayRosterStart;

    @Column(name = "WednesdayRosterFinish")
    private LocalTime wednesdayRosterFinish;

    @Column(name = "ThursdayRosterStart")
    private LocalTime thursdayRosterStart;

    @Column(name = "ThursdayRosterFinish")
    private LocalTime thursdayRosterFinish;

    @Column(name = "FridayRosterStart")
    private LocalTime fridayRosterStart;

    @Column(name = "FridayRosterFinish")
    private LocalTime fridayRosterFinish;

    @Column(name = "SaturdayRosterStart")
    private LocalTime saturdayRosterStart;

    @Column(name = "SaturdayRosterFinish")
    private LocalTime saturdayRosterFinish;

    @Column(name = "SundayRosterStart")
    private LocalTime sundayRosterStart;

    @Column(name = "SundayRosterFinish")
    private LocalTime sundayRosterFinish;

    public RoomServiceEntity(String employeeNumber,
                             String firstName,
                             String middleName,
                             String lastName,
                             String outsourcingCompany) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.outsourcingCompany = outsourcingCompany;
    }
}
