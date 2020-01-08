package com.uni.library.service;

import com.uni.library.model.User;
import com.uni.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteUserByID(Long id){
        userRepository.deleteById(id);
    }

    public void insertUser(User user){
        userRepository.save(user);
    }

    public void updateUserByID(Long id, User updateUser){
        if(userRepository.findById(id).isPresent()){
            updateUser.setId(id);
            userRepository.save(updateUser);
        }
    }
}
