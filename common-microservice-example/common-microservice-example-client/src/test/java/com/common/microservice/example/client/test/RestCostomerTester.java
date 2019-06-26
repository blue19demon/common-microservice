package com.common.microservice.example.client.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.microservice.example.client.CostomerApplication;
import com.common.microservice.example.rest.api.RestOrderService;
import com.common.microservice.example.rest.api.DeptService;
import com.common.microservice.example.rest.vo.Department;
import com.common.microservice.example.rest.vo.RestOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={CostomerApplication.class})
public class RestCostomerTester {

	@Autowired
	private DeptService deptService;
	@Autowired
	private RestOrderService restOrderService;
	@Test
	public void test() {

		List<Department> list = deptService.list();
		for (Department department : list) {
			System.out.println(department);
		}

		System.out.println(deptService.list02("111", "京津冀"));

		System.out.println(deptService.save("京津冀"));
		System.out.println(deptService.saveMuti(887L, "南京城"));
		System.out.println(deptService.get(1L, "cc"));//get中文会乱码
		System.out.println(deptService.update(1L, "看到"));
		deptService.delete(112L);
		

		List<RestOrder> listOrder = restOrderService.list(new BigDecimal(99.9));
		for (RestOrder order : listOrder) {
			System.out.println(order);
		}
	}
	
}
