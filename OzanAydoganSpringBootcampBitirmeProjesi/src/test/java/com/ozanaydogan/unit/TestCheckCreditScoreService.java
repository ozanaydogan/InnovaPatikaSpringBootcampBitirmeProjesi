package com.ozanaydogan.unit;


import com.ozanaydogan.business.services.IUserServices;
import com.ozanaydogan.business.services.impl.CheckCreditScoreService;
import com.ozanaydogan.data.entity.UserEntity;
import com.ozanaydogan.data.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class TestCheckCreditScoreService {

    @Autowired
    private CheckCreditScoreService checkCreditScoreService;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserServices userServices;

    //TEST checkCreditScoreService.checkScore() method
    @Test
    void testCheckScore(){
         UserEntity userEntity = UserEntity.builder().firstName("Ozan").lastName("Aydogan").creditScore(1999).emailId("ozanaydogan1@hotmail.com").salary(9955.0).phoneNumber(5434945208L).
         citizenshipNumber(86349701078L).build();

         userRepository.save(userEntity);

         Assertions.assertEquals(39820.0, checkCreditScoreService.checkScore(userEntity.getCitizenshipNumber()).getCreditLimit(),"hatalı");
    }

}
