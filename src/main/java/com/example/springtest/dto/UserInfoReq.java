package com.example.springtest.dto;

import com.example.springtest.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserInfoReq {

    private Long id;
    private String name;

    @Builder
    public UserInfoReq(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User toEntity() {
        return User
                .builder()
                .id(id)
                .name(name)
                .build();
    }
}

