package com.api.user;
import javax.jws.WebService;

@WebService
public interface UserDemoService {
     public String sayHello(String foo);
}