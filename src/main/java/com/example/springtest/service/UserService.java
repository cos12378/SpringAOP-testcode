package com.example.springtest.service;

import com.example.springtest.dto.UserInfoReq;
import com.example.springtest.dto.UserInfoRes;
import com.example.springtest.entity.User;
import com.example.springtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired //레포지토리 초기화
    private UserRepository userRepository;

    public UserInfoRes findByUserInfo(UserInfoReq userInfoReq){
        User user = userRepository.findByUserInfo(userInfoReq.toEntity());
        return new UserInfoRes(user.getName(),user.getId());
    }

    public UserInfoRes save(UserInfoReq userInfoReq){
        User user = userRepository.save(userInfoReq.toEntity());
        return new UserInfoRes(user.getName(),user.getId());
    }

}
