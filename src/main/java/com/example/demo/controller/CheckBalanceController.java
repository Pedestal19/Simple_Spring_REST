package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class CheckBalanceController {


    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/checkbalance", method = RequestMethod.GET, produces = "application/json")
    public String CheckBalance(@RequestParam(value = "username", defaultValue = "null") String username,
                               HttpSession session) {
        System.out.println("Check Balance Request!");

        if(session.isNew()){
            return "User not logged in error!!";
        }
        else{
            //get user balance from user repository
            for(User user: userRepository.findAll()){
                if(user.getUsername().equals(username)){
                    System.out.println("Current User Balance: " + user.getBalance());
                    try {
                        JSONObject k = new JSONObject();
                        return k.put("balance", user.getBalance()).toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return "{Balance: " + user.getBalance()+"}";
                }
            }

        }
        return "Check Balanced Called!";
    }
}
