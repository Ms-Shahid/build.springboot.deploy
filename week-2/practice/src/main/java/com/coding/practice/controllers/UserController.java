package com.coding.practice.controllers;

import com.coding.practice.dto.UserDTO;
import com.coding.practice.exceptions.ResourceNotFoundException;
import com.coding.practice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService){
        this.userService = userService;
    }


    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable  Long userId){
        Optional<UserDTO> userDTO = userService.getUserById(userId);
        return userDTO
                .map( userDTO1 -> ResponseEntity.ok(userDTO1) )
                .orElseThrow(() -> new ResourceNotFoundException("User Not found!"));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createNewUser( @RequestBody @Valid UserDTO newUser ){
        UserDTO savedUser = userService.createNewUser(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<UserDTO> updateUserId( @RequestBody UserDTO userDTO, @PathVariable Long userId ){
        return ResponseEntity.ok(userService.updateUserId(userDTO, userId));
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long userId){
        boolean isDeleted = userService.deleteUserById(userId);
        if( isDeleted ) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{userId}")
    public ResponseEntity<UserDTO> updatePartialUserById(@RequestBody Map<String, Object> partialUpdates,
                                         @PathVariable Long userId ){
        UserDTO userDTO = userService.updatePartialUserById(partialUpdates, userId);
        if( userDTO == null ) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDTO);
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleUserNotFound(NoSuchElementException exception){
//        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//    }
}
