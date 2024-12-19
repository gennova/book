package com.tendydeveloper.book.controller;

import com.tendydeveloper.book.service.UserService;
import com.tendydeveloper.book.service.entity.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BackendController {
    private static final Logger logger = LogManager.getLogger(BackendController.class);
    private final String index = "/";
    private final String user = "/user";
    @Autowired
    private UserService userService;

    @GetMapping(value = index)
    public String getHealth(){
        String trancationId = String.valueOf(UUID.randomUUID());
        logger.info("[{}] Started request for {} ",trancationId,"/");
        System.out.println("check");
        logger.info("[{}] Finished request for {} ",trancationId,"/");
        return "Hello World";
    }

    @GetMapping(value = user)
    public List<User> getAllUser(){
        String trancationId = String.valueOf(UUID.randomUUID());
        logger.info("[{}] Started request for {} ",trancationId,"/");
        List<User> users = userService.getAllUser();
        logger.info("[{}] Finished request for {} ",trancationId,"/");
        return users;
    }
//
//    @PostMapping(value=user)
//    public User insertUser(@RequestBody User user){
//        return userService.insertUser(user);
//    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserByID(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
}
