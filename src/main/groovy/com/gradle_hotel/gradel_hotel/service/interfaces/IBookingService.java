package com.gradle_hotel.gradel_hotel.service.interfaces;

import com.gradle_hotel.gradel_hotel.model.Booking;
import com.gradle_hotel.gradel_hotel.response.ResponseData;

public interface IBookingService {

    ResponseData saveBooking(Long roomId, Long userId, Booking bookingRequest);

    ResponseData findBookingByConfirmationCode(String confirmationCode);

    ResponseData getAllBookings();

    ResponseData cancelBooking(Long bookingId);

}
