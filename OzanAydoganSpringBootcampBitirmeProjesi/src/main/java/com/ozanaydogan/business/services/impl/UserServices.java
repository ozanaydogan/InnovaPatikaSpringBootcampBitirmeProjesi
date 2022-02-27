package com.ozanaydogan.business.services.impl;

import com.ozanaydogan.business.dto.UserDto;
import com.ozanaydogan.business.services.IUserServices;
import com.ozanaydogan.data.entity.UserEntity;
import com.ozanaydogan.data.repository.IUserRepository;
import com.ozanaydogan.core.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServices implements IUserServices {

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private ModelMapper modelMapper;


    //LIST
    // http://localhost:8081/api/v1/users
    @GetMapping("/users")
    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> listDto = new ArrayList<>();
        Iterable<UserEntity> userList = IUserRepository.findAll();
        for (UserEntity entity : userList) {
            UserDto userDto = EntityToDto(entity);//model
            listDto.add(userDto);
        }
        return  listDto;

    }

    //SAVE
    // http://localhost:8081/api/v1/users
    @Override
    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto userDto) { //@RequestBody
        UserEntity userEntity = DtoToEntity(userDto);//ModelMapper
        IUserRepository.save(userEntity);
        return userDto;
    }

    //FIND
    // http://localhost:8081/api/v1/users/1
    // get employee by id rest api
    @GetMapping("/users/{id}")
    @Override
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserEntity user = IUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
        UserDto userDto = EntityToDto(user);//model
        return ResponseEntity.ok(userDto);
    }


    //UPDATE
    // http://localhost:8081/api/v1/users
    @PutMapping("/users/{id}")
    @Override
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDetails) {
        UserEntity userEntity = DtoToEntity(userDetails);//ModelMapper

        UserEntity user = IUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));

        user.setFirstName( userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmailId(userEntity.getEmailId());
        user.setSalary(userEntity.getSalary());
        user.setPhoneNumber(userEntity.getPhoneNumber());

        UserEntity updatedUser = IUserRepository.save(user);
        UserDto userDto = EntityToDto(updatedUser);//model
        return ResponseEntity.ok(userDto);
    }

    //DELETE
    // http://localhost:8081/api/v1/users
    @DeleteMapping("/users/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id) {
        UserEntity user = IUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));

        IUserRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //Model Mapper Entity ==> Dto
    @Override
    public UserDto EntityToDto(UserEntity employeeEntity) {
        UserDto userDto = modelMapper.map(employeeEntity, UserDto.class);
        return userDto;
    }

    //Model Mapper Dto  ==> Entity
    @Override
    public UserEntity DtoToEntity(UserDto employeeDto) {
        UserEntity userEntity = modelMapper.map(employeeDto, UserEntity.class);
        return userEntity;
    }
}
