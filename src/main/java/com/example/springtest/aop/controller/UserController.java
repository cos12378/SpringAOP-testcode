package com.example.springtest.aop.controller;

import com.example.springtest.dto.UserInfoReq;
import com.example.springtest.dto.UserInfoRes;
import com.example.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired  //유저 서비스 초기화
    private UserService userService;
    @GetMapping
    public UserInfoRes getByUserInfo(@ModelAttribute UserInfoReq userInfoReq) {
        return userService.findByUserInfo(userInfoReq.getId(), userInfoReq.getName());
    }

    @PostMapping
    public UserInfoRes save(@RequestBody UserInfoReq userInfoReq) {
       return userService.save(userInfoReq);
    }

}
