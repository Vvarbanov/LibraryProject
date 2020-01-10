package com.uni.library.service;

import com.uni.library.dto.UserDTO;
import com.uni.library.model.User;
import com.uni.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers (){
        return (List<User>) userRepository.findAll();
    }

    public User getUserByID(Long id){
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        return null;
    }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUserByID(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public Long insertUser(UserDTO userDTO){
        Long id = null;

        if (userDTO != null) {
            User newUser = new User();

            newUser.setEmail(userDTO.getEmail());
            newUser.setName(userDTO.getName());
            newUser.setUsername(userDTO.getUsername());
            newUser.setPassword(userDTO.getPassword());

            id = userRepository.save(newUser).getId();
        }
        return id;
    }

    @Transactional
    public Long updateUserByID(Long id, UserDTO updateUser){
        if(userRepository.findById(id).isPresent() && updateUser != null){
            User newUser = new User();

            newUser.setId(id);
            newUser.setEmail(updateUser.getEmail());
            newUser.setName(updateUser.getName());
            newUser.setUsername(updateUser.getUsername());
            newUser.setPassword(updateUser.getPassword());

            return userRepository.save(newUser).getId();
        }
        return null;
    }
}
