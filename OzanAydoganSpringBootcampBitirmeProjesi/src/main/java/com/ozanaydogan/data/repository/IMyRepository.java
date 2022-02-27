package com.ozanaydogan.data.repository;

import com.ozanaydogan.data.entity.UserEntity;

import java.util.List;

public interface IMyRepository {
    List<UserEntity> findByCitizenshipNumber(Long citizenshipNumber);
}
