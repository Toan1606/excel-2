package com.eric.excel.service;

import com.eric.excel.dto.UserDTO;

import java.util.List;

public interface IUserServices {

    public UserDTO saveUser(UserDTO userRequestDTO);

    public List<UserDTO> findAllUsers();
}
