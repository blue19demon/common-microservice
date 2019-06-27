package com.api.user;

import java.util.ArrayList;

import javax.jws.WebService;

import com.bean.User;

@WebService
public interface UserService {
    String getName(String userId);

    User getUser(String userI);

    ArrayList<User> getAlLUser();
    
    User saveUser(User user);
}