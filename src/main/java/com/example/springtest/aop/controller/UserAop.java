package com.example.springtest.aop.controller;

import com.example.springtest.dto.UserInfoReq;
import com.example.springtest.dto.UserInfoRes;
import com.example.springtest.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Aspect
@Component
public class UserAop {

    @Pointcut // com.example.springtest 하위 클래스들을 전부 적용하겠다고 지점 설정
            ("execution(* com.example.springtest.aop.controller..*.*(..))")
    private void cut() {
    }

    //설정한 지점 cut메서드 이전에 실행하는 before메서드
    @Before("cut()")
    public void before(JoinPoint joinPoint) {

        //실행되는 함수 이름을 가져오고 출력
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName() + "메서드 실행");

        //메서드에 들어가는 매개변수 배열을 읽어옴
        Object[] args = joinPoint.getArgs();

        for (Object obj : args) {
            System.out.println("Request Type: " + obj.getClass().getSimpleName());

            if (obj instanceof UserInfoReq) {
                UserInfoReq userInfoReq = (UserInfoReq) obj;
                if (userInfoReq.getId() != null) {
                    User user = new User(userInfoReq.getId(), userInfoReq.getName());
                    System.out.println("Id: " + user.getId());
                    System.out.println("Name: " + user.getName());
                } else {
                    System.out.println("Id가 null입니다.");
                }
            } else {
                System.out.println("유저가 없습니다.");
            }
        }



    }

    @AfterReturning(value = "cut()", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj) {


        if (obj instanceof UserInfoRes) {
            UserInfoRes userInfoRes = (UserInfoRes) obj;
            User user = new User(userInfoRes.getId(), userInfoRes.getName());
            System.out.println("return obj");
            System.out.println(user);
        }
    }

}

