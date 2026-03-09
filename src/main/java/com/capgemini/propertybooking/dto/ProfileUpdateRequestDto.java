package com.capgemini.propertybooking.dto;

import com.capgemini.propertybooking.enums.Gender;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ProfileUpdateRequestDto {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
