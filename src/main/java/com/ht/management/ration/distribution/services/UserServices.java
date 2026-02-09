package com.ht.management.ration.distribution.services;

import java.util.List;
import java.util.Optional;

import com.ht.management.ration.distribution.constants.UserConstant;
import com.ht.management.ration.distribution.exceptions.UserNotFoundException;
import com.ht.management.ration.distribution.model.User;
import com.ht.management.ration.distribution.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

   public Optional<User> getUserById(Long userId) {
       try {
           return userRepository.findById(userId);
       } catch (UserNotFoundException exception) {
           log.error(UserConstant.RESOURCE_NOT_FOUND + " userId: {}, exception: {}", userId, exception.getMessage());
           return Optional.empty();
       }
   }

   public Optional<User> getUserByRole(String role) {
       try {
           return Optional.ofNullable(userRepository.findByRole(role));
       } catch (UserNotFoundException exception) {
           log.error(UserConstant.RESOURCE_NOT_FOUND + " role: {}, exception: {}", role, exception.getMessage());
           return Optional.empty();
       }
   }

   public List<User> getAllUsers() {
       return userRepository.findAll();
   }

  public User updateUser(Long userId, User updatedUser) {
      return userRepository.findById(userId)
              .map(user -> {
                  user.setUsername(updatedUser.getUsername());
                  user.setPassword(updatedUser.getPassword());
                  user.setRationCardNumber(updatedUser.getRationCardNumber());
                  user.setAddress(updatedUser.getAddress());
                  user.setPhoneNumber(updatedUser.getPhoneNumber());
                  return userRepository.save(user);
              })
              .orElseThrow(() -> new UserNotFoundException(UserConstant.USER_NOT_FOUND + userId));
  }

  public void deleteUser(Long userId) {
      if (userRepository.existsById(userId)) {
          userRepository.deleteById(userId);
      } else {
          throw new UserNotFoundException(UserConstant.USER_NOT_FOUND + userId);
      }
  }

}
