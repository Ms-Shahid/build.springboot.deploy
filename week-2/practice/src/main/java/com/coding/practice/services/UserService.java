package com.coding.practice.services;

import com.coding.practice.dto.UserDTO;
import com.coding.practice.entities.User;
import com.coding.practice.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<UserDTO> getUserById(Long id){
        //Optional<User> user =  userRepository.findById(id);
//        return new UserDTO(
//               user.getId(), user.getName(), user.getEmail(), user.getAge()
//        );

        //return modelMapper.map( user, UserDTO.class ); //map( source, target ), maps source to target
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class));
    }

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList
                    .stream()
                    .map(user -> modelMapper.map(user, UserDTO.class))
                    .toList();
    }

    public UserDTO createNewUser(UserDTO newUser) {
        User userDTOToUser = modelMapper.map(newUser, User.class);
        User savedUser = userRepository.save(userDTOToUser);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO updateUserId(UserDTO userDTO, Long userId) {
        User user = modelMapper.map( userDTO, User.class );
        user.setUserId(userId);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);

    }


    public boolean deleteUserById(Long userId) {
        isExistsByUserById(userId);
        userRepository.deleteById(userId);
        return isExistsByUserById(userId);
    }

    public UserDTO updatePartialUserById(Map<String, Object> partialUpdates, Long userId) {

        isExistsByUserById(userId);
        User user = userRepository.findById(userId).orElse(null);

        partialUpdates.forEach((field, value) -> {
            Field fieldToBeUpdated = findRequiredField(User.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, user, value);
        });
        return modelMapper.map( userRepository.save(user), UserDTO.class);
    }

    public boolean isExistsByUserById(Long userId){
        return userRepository.existsById(userId);
    }

    public static Field findRequiredField(Class<?> type, String name){
        Field result = org.springframework.util.ReflectionUtils.findField(type, name);
        if( result == null ){
            throw new IllegalArgumentException(String.format("unable to find field"));
        }else{
            return result;
        }

    }
}
