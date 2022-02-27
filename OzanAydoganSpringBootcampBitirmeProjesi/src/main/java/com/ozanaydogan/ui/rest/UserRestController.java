package com.ozanaydogan.ui.rest;

import com.ozanaydogan.business.dto.UserDto;
import com.ozanaydogan.business.services.impl.UserServices;
import com.ozanaydogan.core.randomnumber.RandomNumberGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserRestController {

    @Autowired
    public UserServices userServices;

    // ROOT
    // http://localhost:8081/api/v1/index
    @GetMapping("/index")
    @ResponseBody
    public String getRoot() {
        return "index Sayfası";
    }

    //LIST
    // http://localhost:8081/api/v1/users
    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        List<UserDto> userDto =  userServices.getAllUsers();
        for(UserDto temp :userDto){
            log.info("user = " + temp  + "getirildi");
        }
        return userDto;
    }

    //FIND
    // http://localhost:8081/api/v1/users/1
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        ResponseEntity<UserDto> userDto = userServices.getUserById(id);
        log.info(id + " numaralı id getirildi"+ userDto);
        return userDto;
    }

    //SAVE
    // http://localhost:8081/api/v1/users
    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        if(userDto.getCreditScore()==null) {
            userDto.setCreditScore(RandomNumberGenerator.createRandomNumber());
        }
        userServices.createUser( userDto );

        log.info("DB'ye eklendi"+ userDto);

        return userDto;
    }

    //UPDATE
    // http://localhost:8081/api/v1/users/2
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDetails) {
        userServices.updateUser(id, userDetails);
        log.info("olarak guncellendi" + userDetails);
        return ResponseEntity.ok(userDetails);
    }

    //DELETE
    // http://localhost:8081/api/v1/users/7
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
        log.info(id + " numaralı id silindi");
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
