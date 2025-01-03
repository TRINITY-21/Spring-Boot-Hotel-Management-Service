package com.gradle_hotel.gradel_hotel.service.interfaces;

import com.gradle_hotel.gradel_hotel.model.UserRole;
import com.gradle_hotel.gradel_hotel.request.LoginRequest;
import com.gradle_hotel.gradel_hotel.request.PasswordResetRequest;
import com.gradle_hotel.gradel_hotel.response.ResponseData;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {

    ResponseData register(MultipartFile profileImage, String username, String password,
                          String city, String address,
                          String phone, String email, UserRole userRole);

    ResponseData login(LoginRequest loginRequest);

    ResponseData getAllUsers();

    ResponseData addUser(MultipartFile profileImage, String username, String password,
                          String city, String address,
                          String phone, String email, UserRole userRole);

    ResponseData getUserBookingHistory(String userId);

    ResponseData deleteUser(String userId);

    ResponseData getUserById(String userId);

    ResponseData getUserInfo(String email);

    ResponseData activateEmailCode(String code);

    ResponseData sendPasswordResetCode(String email);

    ResponseData resetPassword(PasswordResetRequest request);

    ResponseData getEmailByPasswordResetCode(String code);

    ResponseData updateUser(Long userId,MultipartFile profileImage,String username, String email, String city, String address,String phone, UserRole userRole);

}
