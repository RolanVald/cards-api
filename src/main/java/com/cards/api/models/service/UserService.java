package com.cards.api.models.service;

import com.cards.api.models.dto.UserDTO;

public interface UserService {

    UserDTO findUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
}
