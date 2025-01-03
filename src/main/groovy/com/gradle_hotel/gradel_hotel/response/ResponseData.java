package com.gradle_hotel.gradel_hotel.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gradle_hotel.gradel_hotel.dto.BookingDto;
import com.gradle_hotel.gradel_hotel.dto.RoomDto;
import com.gradle_hotel.gradel_hotel.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData {

    //mapping our response obj to return
    private int statusCode;

    private String message;

    private String token;

    private String role;

    private String expiresIn;

    private String bookingConfirmationCode;

    private UserDto user;

    private RoomDto room;

    private BookingDto booking;

    private List<UserDto> userList;

    private List<RoomDto> roomList;

    private List<BookingDto> bookingList;

}
