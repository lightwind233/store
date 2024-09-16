package com.cy.store.service;

import com.cy.store.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Autowired
    IUserService userService;

    @Test
    public void create() {
        Integer[] cids = {2,4,6};
        Order order = orderService.create(13, cids, 11, "小红");
        System.out.println(order);
    }
}
