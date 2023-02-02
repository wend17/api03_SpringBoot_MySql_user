package com.demo.api.controller;

import com.demo.api.entity.User;
import com.demo.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apirest")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public  ResponseEntity<User>save(@RequestBody User user){
    return  new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>>findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User>findById(@PathVariable Integer id){
        return new ResponseEntity<>(userService.get(id),(HttpStatus.OK));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User>delete(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity (HttpStatus.OK);
    }
}
