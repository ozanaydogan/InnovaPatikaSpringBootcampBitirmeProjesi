package com.ozanaydogan.business.services.impl;

import com.ozanaydogan.business.dto.UserDto;
import com.ozanaydogan.business.services.ICheckCreditScoreService;
import com.ozanaydogan.data.entity.UserEntity;
import com.ozanaydogan.data.repository.IMyRepository;
import com.ozanaydogan.data.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CheckCreditScoreService implements ICheckCreditScoreService {


    @Autowired
    private IMyRepository myRepositoryImp;

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto checkScore(Long citizenshipNumber) {
        UserDto userDto = this.getUserByCitizenshipNumber(citizenshipNumber);

            if (userDto.getCreditScore() < 500) { //kredi skoru 500'den kücükse
                userDto.setCreditStatus(Boolean.FALSE);
                IUserRepository.save(DtoToEntity(userDto));
                return userDto;
            } else if (userDto.getCreditScore() < 1000 && userDto.getCreditScore() >= 500) { //kredi skoru 500'den buyuk 1000'den kucukse

                if (userDto.getSalary() < 5000.0) {
                    userDto.setCreditLimit(10000.0);
                    userDto.setCreditStatus(Boolean.TRUE);
                    IUserRepository.save(DtoToEntity(userDto));
                    return userDto;
                } else if (userDto.getSalary() >= 5000.0) {
                    userDto.setCreditLimit(20000.0);
                    userDto.setCreditStatus(Boolean.TRUE);
                    IUserRepository.save(DtoToEntity(userDto));
                    return userDto;
                }

            } else if (userDto.getCreditScore() >= 1000) {  //kredi skoru 1000'e esit ya da buyukse
                userDto.setCreditLimit((userDto.getSalary() * 4.0));
                userDto.setCreditStatus(Boolean.TRUE);
                IUserRepository.save(DtoToEntity(userDto));
                return userDto;
            } else {
                return null;
            }
        return null;

    }

    // kimlik numarasına gore sorgu
    @Override
    public UserDto getUserByCitizenshipNumber(Long citizenshipNumber) {
        List<UserEntity> user = myRepositoryImp.findByCitizenshipNumber(citizenshipNumber);
        UserDto userDto = EntityToDto(user.get(0));//model
        return userDto;
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
