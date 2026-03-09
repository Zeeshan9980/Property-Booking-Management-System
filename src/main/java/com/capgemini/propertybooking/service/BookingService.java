package com.capgemini.propertybooking.service;

import com.capgemini.propertybooking.dto.BookingDto;
import com.capgemini.propertybooking.dto.BookingRequest;
import com.capgemini.propertybooking.dto.HotelReportDto;
import com.capgemini.propertybooking.enums.BookingStatus;
import jdk.jfr.Event;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<Long> guestIdList);

    String initiatePayments(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

    BookingStatus getBookingStatus(Long bookingId);

    List<BookingDto> getAllBookingsByHotelId(Long hotelId);

    HotelReportDto getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate);

    List<BookingDto> getMyBookings();

}
