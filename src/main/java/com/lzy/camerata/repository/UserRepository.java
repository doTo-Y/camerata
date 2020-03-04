package com.lzy.camerata.repository;

import com.lzy.camerata.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



@Mapper
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select * from USER where token = ? ",nativeQuery = true)
    User findMyToken(@Param("token") String token);

}
