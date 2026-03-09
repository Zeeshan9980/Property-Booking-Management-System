package com.capgemini.propertybooking.repository;

import com.capgemini.propertybooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
