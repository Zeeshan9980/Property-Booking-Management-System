package com.capgemini.propertybooking.service;

import com.capgemini.propertybooking.dto.HotelPriceResponseDto;
import com.capgemini.propertybooking.dto.HotelSearchRequest;
import com.capgemini.propertybooking.dto.InventoryDto;
import com.capgemini.propertybooking.dto.UpdateInventoryRequestDto;
import com.capgemini.propertybooking.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
