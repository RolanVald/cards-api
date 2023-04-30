package com.cards.api.logic;

import com.cards.api.models.dto.UserDTO;
import com.cards.api.models.service.UserService;
import com.cards.api.models.service.validations.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCRUDLogic {

    @Autowired
    private UserService userService;
    @Autowired
    private NumberService numberService;

    public UserDTO  findUser(Long id) {
        numberService.throwsExceptionIfNumberIsNotValid(id);
        return userService.findUserById(id);
    }

    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}
