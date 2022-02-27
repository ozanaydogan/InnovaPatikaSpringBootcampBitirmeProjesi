package com.ozanaydogan.data.repository.impl;

import com.ozanaydogan.data.entity.UserEntity;
import com.ozanaydogan.data.repository.IMyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;

@Repository
public class MyRepositoryImp implements IMyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //veri tabanından kimlik numarasina gore sorgu yapip kullaniciyi getirme
    @Override
    public List<UserEntity> findByCitizenshipNumber(Long citizenshipNumber) {
        //SELECT * FROM innova_patika_project_1.computer where computer_price>66;
        String jpql="select c from UserEntity c where c.citizenshipNumber =: key";
        TypedQuery<UserEntity> typedQuery= entityManager.createQuery(jpql,UserEntity.class);
        typedQuery.setParameter("key",citizenshipNumber);
        return typedQuery.getResultList();
    }
}
