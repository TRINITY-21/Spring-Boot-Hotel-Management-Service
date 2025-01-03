package com.gradle_hotel.gradel_hotel.controller;

import com.gradle_hotel.gradel_hotel.constants.Pages;
import com.gradle_hotel.gradel_hotel.model.UserRole;
import com.gradle_hotel.gradel_hotel.request.LoginRequest;
import com.gradle_hotel.gradel_hotel.request.PasswordResetRequest;
import com.gradle_hotel.gradel_hotel.response.ResponseData;
import com.gradle_hotel.gradel_hotel.service.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Pages.AUTH_BASE)
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping(Pages.REGISTER)
    public ResponseEntity<ResponseData> register (
            @RequestParam(value = "profileImage", required = false) MultipartFile profileImage,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "role", required = false) UserRole role


    ){
        ResponseData responseData = userService.register(profileImage,username,password,city, address,
                 phone, email, role);
        return ResponseEntity.status(responseData.getStatusCode()).body(responseData);
    }

    @PostMapping(Pages.LOGIN)
    public ResponseEntity<ResponseData> login (@RequestBody LoginRequest loginRequest){
        ResponseData responseData = userService.login(loginRequest);
        return ResponseEntity.status(responseData.getStatusCode()).body(responseData);
    }

    @GetMapping(Pages.ACTIVATE_EMAIL)
    public ResponseEntity<ResponseData> activateEmailCode(@PathVariable("code") String code, Model model) {
        ResponseData responseData = userService.activateEmailCode(code);
        return ResponseEntity.status(responseData.getStatusCode()).body(responseData);
    }



    @PostMapping(Pages.FORGOT_PASSWORD)
    public ResponseData forgotPassword(@RequestBody PasswordResetRequest request) {
        System.out.println(request + "req email");
        ResponseData responseData = userService.sendPasswordResetCode(request.getEmail());
        return ResponseEntity.status(responseData.getStatusCode()).body(responseData).getBody();
    }


    @GetMapping(Pages.RESET_PASSWORD)
    public ResponseData resetPassword(@PathVariable("code") String code) {
        ResponseData responseData = new ResponseData();
        System.out.println(code + "req email");
        responseData = userService.getEmailByPasswordResetCode(code);
        System.out.println(responseData + "req user");
        return ResponseEntity.status(responseData.getStatusCode()).body(responseData).getBody();
    }


    @PostMapping(Pages.RESET_PASSWORD)
    public ResponseData resetPassword(@PathVariable("code") String code, @Valid @RequestBody PasswordResetRequest request, Model model) {
        ResponseData responseData = userService.getEmailByPasswordResetCode(code);

        if (responseData.getStatusCode() != 200 || request.getEmail() == null || request.getEmail().isEmpty()) {
            responseData.setStatusCode(400);
            responseData.setMessage("Invalid reset code or email not provided");
            return ResponseEntity.status(responseData.getStatusCode()).body(responseData).getBody();
        }

        // Proceed with password reset
        responseData = userService.resetPassword(request);

        // Check if resetPassword was successful
        if (responseData.getStatusCode() == 200) {
            responseData.setMessage("Password reset successful");
        } else {
            responseData.setStatusCode(500); // Or appropriate error code
            responseData.setMessage("Failed to reset password");
        }

        return ResponseEntity.status(responseData.getStatusCode()).body(responseData).getBody();
    }


}
