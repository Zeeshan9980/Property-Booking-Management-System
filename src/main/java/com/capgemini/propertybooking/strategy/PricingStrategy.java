package com.capgemini.propertybooking.strategy;

import com.capgemini.propertybooking.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Inventory inventory);
}
