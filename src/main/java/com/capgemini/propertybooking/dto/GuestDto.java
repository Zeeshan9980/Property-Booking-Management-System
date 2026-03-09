package com.capgemini.propertybooking.dto;

import com.capgemini.propertybooking.enums.Gender;
import lombok.Data;

import java.time.LocalDate;
@Data
public class GuestDto {
    private Long id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
}
