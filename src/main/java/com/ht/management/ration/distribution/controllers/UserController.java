package com.ht.management.ration.distribution.controllers;

import com.ht.management.ration.distribution.constants.GlobalConstant;
import com.ht.management.ration.distribution.exceptions.UserNotFoundException;
import com.ht.management.ration.distribution.model.User;
import com.ht.management.ration.distribution.services.UserServices;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/api/v1/users")
public class UserController {
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> addUserToDataBase(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null || user.getRole() == null) {
            return ResponseEntity
                    .badRequest()
                    .body(GlobalConstant.USERNAME_PASSWORD_ROLE_REQUIRED);
        }
        User createdUser = userServices.createUser(user);
        log.info(GlobalConstant.USER_CREATED_SUCCESSFULLY);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return userServices.getUserById(userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.error("{}{}", GlobalConstant.USER_NOT_FOUND, userId);
                    return ResponseEntity
                            .status(404)
                            .build();
                });
    }

    @GetMapping("/getUserByRole/{role}")
    public ResponseEntity<User> getUserByRole(@PathVariable String role) {
        return userServices.getUserByRole(role)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.error("{}{}", GlobalConstant.USER_NOT_FOUND, role);
                    return ResponseEntity
                            .status(404)
                            .build();
                });
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userServices.getAllUsers());
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@RequestParam Long userId, @RequestBody User updatedUser) {
        try {
            User user = userServices.updateUser(userId, updatedUser);
            log.info(GlobalConstant.USER_UPDATED_SUCCESSFULLY);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException exception) {
            log.error("{}{}, exception: {}", GlobalConstant.USER_NOT_FOUND, userId, exception.getMessage());
            return ResponseEntity
                    .status(404)
                    .body(GlobalConstant.USER_NOT_FOUND + userId);
        }
    }

   @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        try {
            userServices.deleteUser(userId);
            log.info(GlobalConstant.USER_DELETED_SUCCESSFULLY);
            return ResponseEntity.ok(GlobalConstant.USER_DELETED_SUCCESSFULLY);
        } catch (UserNotFoundException exception) {
            log.error("{}{}, exception: {}", GlobalConstant.USER_NOT_FOUND, userId, exception.getMessage());
            return ResponseEntity
                    .status(404)
                    .body(GlobalConstant.USER_NOT_FOUND + userId);
        }
    }
}
