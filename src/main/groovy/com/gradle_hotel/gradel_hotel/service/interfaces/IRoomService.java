package com.gradle_hotel.gradel_hotel.service.interfaces;

import com.gradle_hotel.gradel_hotel.response.ResponseData;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface IRoomService {

    ResponseData addNewRoom(MultipartFile image, String name, String type, Double price, String description);

    List<String> getAllRoomTypes();

    ResponseData getAllRooms();

    ResponseData deleteRoom(Long roomId);

    ResponseData updateRoom(Long roomId, String description,String roomType, String name,  Double roomPrice, MultipartFile photo);

    ResponseData getRoomById(Long roomId);

    ResponseData getAvailableRoomsByDataAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType);

    ResponseData getAllAvailableRooms();
}

