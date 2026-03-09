package com.capgemini.propertybooking.dto;

import com.capgemini.propertybooking.entity.HotelContactInfo;

public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;
}
