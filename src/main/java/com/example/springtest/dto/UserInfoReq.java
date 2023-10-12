package com.example.springtest.dto;

import com.example.springtest.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserInfoReq {

    private String name;
    private Long id;

    @Builder
    public UserInfoReq(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public User toEntity() {
        return User
                .builder()
                .name(name)
                .id(id)
                .build();
    }
}

