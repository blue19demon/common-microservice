package com.dbgo.webservicedemo.service;

import java.util.ArrayList;

import javax.jws.WebService;

import com.dbgo.webservicedemo.Model.User;

@WebService
public interface UserService {
    String getName(String userId);

    User getUser(String userI);

    ArrayList<User> getAlLUser();
    
    User saveUser(User user,String name);
}