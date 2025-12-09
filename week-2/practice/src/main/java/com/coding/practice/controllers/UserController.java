package com.coding.practice.controllers;

import com.coding.practice.dto.UserDTO;
import com.coding.practice.entities.User;
import com.coding.practice.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @GetMapping("/{userId}")
    public User getUserById(@PathVariable  Long userId){
//            return new UserDTO(
//                    userId, "Shahid", "msshahid@gmail.com",25
//            );

        return userRepository.findById(userId).orElse(null);
    }

    @GetMapping
    public List<User> getAllUsers(/*@RequestParam Integer age*/){

//        return List.of(
//                new UserDTO(1L, "Shahid", "ms2406@gmail.com", age),
//                new UserDTO(2L, "Tasmiya", "Tasmiya123@gmai.com", age)
//        );
        return userRepository.findAll();
    }

    @PostMapping
    public User createNewUser( @RequestBody User newUser ){
//        userDTO.setUserId(100L);
//        return userDTO;
        return userRepository.save(newUser);


    }

}
