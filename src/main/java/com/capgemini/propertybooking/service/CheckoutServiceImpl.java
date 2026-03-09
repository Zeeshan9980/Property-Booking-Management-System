import com.capgemini.propertybooking.entity.Booking;
import com.capgemini.propertybooking.repository.BookingRepository;
import com.capgemini.propertybooking.service.CheckoutService;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private static final Logger log = LoggerFactory.getLogger(CheckoutServiceImpl.class);

    private final BookingRepository bookingRepository;

    public CheckoutServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public String getCheckoutSession(Booking booking, String successUrl, String failureUrl) {

        log.info("Creating session for booking with ID: {}", booking.getId());

        UserDetails user = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        try {

            CustomerCreateParams customerParams = CustomerCreateParams.builder()
                    .setName(user.getUsername())
                    .setEmail(user.getUsername())
                    .build();

            Customer customer = Customer.create(customerParams);

            SessionCreateParams sessionParams = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setBillingAddressCollection(SessionCreateParams.BillingAddressCollection.REQUIRED)
                    .setCustomer(customer.getId())
                    .setSuccessUrl(successUrl)
                    .setCancelUrl(failureUrl)
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency("inr")
                                                    .setUnitAmount(
                                                            booking.getAmount()
                                                                    .multiply(BigDecimal.valueOf(100))
                                                                    .longValue()
                                                    )
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName(booking.getHotel().getName()
                                                                            + " : "
                                                                            + booking.getRoom().getType())
                                                                    .setDescription("Booking ID: " + booking.getId())
                                                                    .build()
                                                    )
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();

            Session session = Session.create(sessionParams);

            booking.setPaymentSessionId(session.getId());
            bookingRepository.save(booking);

            log.info("Session created successfully for booking with ID: {}", booking.getId());

            return session.getUrl();

        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}