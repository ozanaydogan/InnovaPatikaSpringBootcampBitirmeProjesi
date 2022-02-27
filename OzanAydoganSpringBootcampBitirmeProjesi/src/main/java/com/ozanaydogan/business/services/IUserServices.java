package com.ozanaydogan.business.services;

import com.ozanaydogan.business.dto.UserDto;
import com.ozanaydogan.data.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface IUserServices {
    public List<UserDto> getAllUsers();
    public UserDto createUser(UserDto userDto);
    public ResponseEntity<UserDto> getUserById(Long id);
    public ResponseEntity<UserDto> updateUser(Long id, UserDto userDto);
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id);

    //model mapper
    public UserDto EntityToDto(UserEntity employeeEntity);
    public UserEntity DtoToEntity(UserDto employeeDto);
}
