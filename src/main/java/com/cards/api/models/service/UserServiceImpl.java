package com.cards.api.models.service;

import com.cards.api.exception.custom.EntityNotFoundException;
import com.cards.api.mapper.UserMapper;
import com.cards.api.models.dto.UserDTO;
import com.cards.api.models.entity.User;
import com.cards.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    static final Logger LOG = LoggerFactory.getLogger(CardsServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDTO(user);
    }
}
