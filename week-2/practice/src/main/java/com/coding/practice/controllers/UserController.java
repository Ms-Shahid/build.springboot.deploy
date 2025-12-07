package com.coding.practice.controllers;

import com.coding.practice.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable  Long userId){
            return new UserDTO(
                    userId, "Shahid", "msshahid@gmail.com",25
            );
    }

    @GetMapping
    public List<UserDTO> getAllUsers(@RequestParam Integer age){

        return List.of(
                new UserDTO(1L, "Shahid", "ms2406@gmail.com", age),
                new UserDTO(2L, "Tasmiya", "Tasmiya123@gmai.com", age)
        );
    }

    @PostMapping
    public UserDTO createNewUser( @RequestBody UserDTO userDTO ){
        userDTO.setUserId(100L);
        return userDTO;
    }

}
