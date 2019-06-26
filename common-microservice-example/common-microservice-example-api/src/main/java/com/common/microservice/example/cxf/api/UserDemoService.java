package com.common.microservice.example.cxf.api;
import javax.jws.WebService;

@WebService
public interface UserDemoService {
     public String sayHello(String foo);
}