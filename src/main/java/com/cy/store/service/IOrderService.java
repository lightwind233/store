package com.cy.store.service;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

import java.util.List;

public interface IOrderService {
    Order create(Integer aid, Integer[] cids, Integer uid, String username);

    List<Order> findByUid(Integer uid);

    List<OrderItem> findByoid(Integer oid);

    void addComment(Integer orderId,Integer productId, Integer uid, String content,Integer rate);
}