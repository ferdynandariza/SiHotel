package com.hospitality.SiHotel.dto.roomService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertRosterDTO {

    private String employeeNumber;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime mondayRosterStart;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime mondayRosterFinish;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime tuesdayRosterStart;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime tuesdayRosterFinish;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime wednesdayRosterStart;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime wednesdayRosterFinish;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime thursdayRosterStart;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime thursdayRosterFinish;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime fridayRosterStart;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime fridayRosterFinish;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime saturdayRosterStart;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime saturdayRosterFinish;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime sundayRosterStart;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime sundayRosterFinish;

}
