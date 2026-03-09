package com.capgemini.propertybooking.repository;

import com.capgemini.propertybooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
