package com.uni.library.repository;

import com.uni.library.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository  extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}
