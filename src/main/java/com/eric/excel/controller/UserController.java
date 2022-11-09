package com.eric.excel.controller;

import com.eric.excel.dto.UserDTO;
import com.eric.excel.service.IUserServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUserServices userServices;

    public UserController(@Qualifier("userServices") IUserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO response = userServices.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
