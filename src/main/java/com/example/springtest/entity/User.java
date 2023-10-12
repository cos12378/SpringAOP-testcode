package com.example.springtest.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @Override
    public String toString(){
        return "User{id=" +id + ", name = '"+ name + "'}";
    }
}
