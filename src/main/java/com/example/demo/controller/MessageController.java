package com.example.demo.controller;

import com.example.demo.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: Hosanna Gabe-Oji.
 * Project: demo.
 * Date: 4/3/2020.
 */
@Controller
public class MessageController {

    @ResponseBody
    @GetMapping("/message")
    Message send(){
        return new Message("first message");
    }
}
