package com.gradle_hotel.gradel_hotel.mapper;

import com.gradle_hotel.gradel_hotel.dto.UserDto;
import com.gradle_hotel.gradel_hotel.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto mapUserEntityToUserDto(User user) {
        UserDto userDto = new UserDto();

        //we ignore the password and bookings
        userDto.setId(user.getId());
        userDto.setUsername(user.getDisplayName());
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setProfileImage(user.getProfileImage());
        userDto.set_deleted(user.is_deleted());
        userDto.setActive(user.isActive());

        return userDto;

    }

    public static UserDto mapUserEntityToUserDtoPlusUserBookingsAndRoom(User user) {
        UserDto userDto = new UserDto();

        //we ignore the password and bookings
        userDto.setId(user.getId());
        userDto.setUsername(user.getDisplayName());
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setProfileImage(user.getProfileImage());

        if(!user.getBookings().isEmpty()){
            userDto.setBookings(user.getBookings().stream()
                    .map(booking -> BookingMapper.mapBookingEntityToBookingDTOPlusBookedRooms(booking, false))
                    .collect(Collectors.toList()));
        }
        return userDto;

    }

    public static List<UserDto> mapUserListEntityToUserListDTO(List<User> userList) {
        return userList.stream().map(UserMapper::mapUserEntityToUserDto).collect(Collectors.toList());
    }




}
