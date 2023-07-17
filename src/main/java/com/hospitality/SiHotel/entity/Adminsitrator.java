package com.hospitality.SiHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Administrators")
public class Adminsitrator {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "JobTitle", nullable = false)
    private String jobTitle;
}
