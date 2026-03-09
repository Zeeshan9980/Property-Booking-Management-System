package com.capgemini.propertybooking.service;

import com.capgemini.propertybooking.entity.Booking;

public interface CheckoutService {
    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);
}
