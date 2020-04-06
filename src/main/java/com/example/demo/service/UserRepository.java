package com.example.demo.service;



import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer> {
    User findByBalance(String username);

}
