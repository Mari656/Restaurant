package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 5/04/2018.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneByEmail(String email);

}
