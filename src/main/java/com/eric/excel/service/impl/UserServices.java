package com.eric.excel.service.impl;


import com.eric.excel.configuration.JpaConfiguration;
import com.eric.excel.dto.UserDTO;
import com.eric.excel.model.User;
import com.eric.excel.repository.UserRepository;
import com.eric.excel.service.IUserServices;
import lombok.Value;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices implements IUserServices {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final JpaConfiguration jpaConfiguration;

    public UserServices(ModelMapper modelMapper, UserRepository userRepository, JpaConfiguration jpaConfiguration) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.jpaConfiguration = jpaConfiguration;
    }

    @Override
    public UserDTO saveUser(UserDTO userRequestDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        User user = modelMapper.map(userRequestDTO, User.class);
        User savedUser = userRepository.saveAndFlush(user);
        UserDTO userDTO = modelMapper.map(savedUser, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> userList = userRepository.findAll(Sort.by(jpaConfiguration.getFields()).descending());
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }


}
