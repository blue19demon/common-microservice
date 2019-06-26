package com.common.microservice.example.cxf.api;

import java.util.ArrayList;

import javax.jws.WebService;

import com.common.microservice.example.cxf.vo.User;

@WebService
public interface UserService {
    String getName(String userId);

    User getUser(String userI);

    ArrayList<User> getAlLUser();
    
    User saveUser(User user,String name);
}