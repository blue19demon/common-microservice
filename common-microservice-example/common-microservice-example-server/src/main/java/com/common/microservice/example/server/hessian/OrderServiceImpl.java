package com.common.microservice.example.server.hessian;

import com.caucho.hessian.server.HessianServlet;
import com.common.microservice.example.hessian.api.OrderService;
import com.common.microservice.example.hessian.vo.Order;
import com.microservice.annotation.RemoteService;
@RemoteService
public class OrderServiceImpl  extends HessianServlet  implements OrderService{

    /**
     * 
     */
    private static final long serialVersionUID = -3537274030227675984L;

    @Override
    public String helloWorld(String message) {
        return "Hello, " + message;
    }

    @Override
    public Order getMyInfo(Order order) {
        if(null == order){ return new Order(); }
        System.out.println(order);
        order.setAge(99);
        return order;
    }
}
