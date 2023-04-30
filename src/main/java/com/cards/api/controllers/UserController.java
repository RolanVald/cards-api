package com.cards.api.controllers;

import com.cards.api.logic.UserCRUDLogic;
import com.cards.api.models.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserCRUDLogic userLogic;

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id)  {
        return ResponseEntity.ok(userLogic.findUser(id));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userLogic.createUser(userDTO));
    }
}
