package com.ozanaydogan.business.services;

import com.ozanaydogan.business.dto.UserDto;
import com.ozanaydogan.data.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface ICheckCreditScoreService {

    public UserDto checkScore(Long citizenshipNumber);

    public UserDto getUserByCitizenshipNumber(Long citizenshipNumber);

    //model mapper
    public UserDto EntityToDto(UserEntity employeeEntity);
    public UserEntity DtoToEntity(UserDto employeeDto);

}
