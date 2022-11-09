package com.eric.excel.service;


import com.eric.excel.dto.UserDTO;
import com.eric.excel.model.User;
import com.eric.excel.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements IUserServices {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    public UserServices(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
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
}
