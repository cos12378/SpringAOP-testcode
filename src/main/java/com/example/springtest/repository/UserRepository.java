package com.example.springtest.repository;

import com.example.springtest.dto.UserInfoReq;
import com.example.springtest.dto.UserInfoRes;
import com.example.springtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.id = :#{#user.id} AND u.name = :#{#user.name}")
    public User findByUserInfo(@Param("user") User user);

}
