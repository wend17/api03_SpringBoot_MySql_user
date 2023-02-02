package com.demo.api.service;

import com.demo.api.entity.User;
import com.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
   private UserRepository userRepository;

   public List<User>findAll(){
       return userRepository.findAll();
   }
   public User save (User user){
       return userRepository.save(user);
   }
   public User get (Integer id){
       return userRepository.findById(id).get();
   }

   public void delete (Integer id){
       userRepository.deleteById(id);
   }
}
