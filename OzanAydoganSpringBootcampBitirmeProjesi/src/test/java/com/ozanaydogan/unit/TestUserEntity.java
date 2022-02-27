package com.ozanaydogan.unit;

import com.ozanaydogan.data.entity.UserEntity;
import com.ozanaydogan.data.repository.IUserRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TestUserEntity {

    @Autowired
    IUserRepository userRepository;

    //CREATE test
    @Test
    void createTest(){
        UserEntity userEntity=new UserEntity();
        userEntity.setFirstName("Ozan");
        userEntity.setLastName("Aydogan");
        userRepository.save(userEntity);
        Assertions.assertNotNull(userRepository.findById(3L).get());
    }

    //LIST test
    @Test
    void listTest(){
        List<UserEntity> listem=userRepository.findAll();
        assertThat(listem).size().isGreaterThan(0);
    }

    //FIND test
    @Test
    void findTest(){
        UserEntity find=userRepository.findById(1L).get();
        assertEquals("Ozan",find.getFirstName());
    }

    //UPDATE test
    @Test
    void updateTest(){
        UserEntity update=userRepository.findById(1L).get();
        update.setLastName("degistirdim");
        userRepository.save(update);
        assertNotEquals("eski yapı",update.getLastName());
    }

    //DELETE test
    @Test
    void deleteTest(){
        userRepository.deleteById(1L);
        AssertionsForClassTypes.assertThat(userRepository.existsById(1L)).isFalse();
    }

}
