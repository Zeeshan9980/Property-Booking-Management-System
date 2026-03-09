package com.capgemini.propertybooking.repository;

import com.capgemini.propertybooking.entity.Guest;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUser(User user);

}
