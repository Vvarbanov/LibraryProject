package com.uni.library.repository;

import com.uni.library.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
