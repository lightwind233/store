package com.cy.store.controller;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.service.ex.UsernameNotFoundException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICartService cartService;



    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) {


        Order data = orderService.create(
                aid,
                cids,
                getUidFromSession(session),
                getUsernameFromSession(session));
        for(Integer cid:cids)
        {
            System.out.println("orderrrr"+cid);
            cartService.deleteToCart(cid);
        }
        return new JsonResult<>(OK,data);
    }
    @RequestMapping("find_by_uid/{uid}")
    public JsonResult<List<Order>> findByUid(@PathVariable("uid") Integer uid,HttpSession session) {
        System.out.println(uid);
        List<Order> data = orderService.findByUid(uid);
        System.out.println(data);
        return new JsonResult<>(OK,data);
    }
    @RequestMapping("{oid}")
    public JsonResult<List<OrderItem>> findByOid(@PathVariable("oid") Integer oid) {
        List<OrderItem> data = orderService.findByoid(oid);
        System.out.println(data);
        return new JsonResult<>(OK,data);
    }
    @RequestMapping("/addComment")
    public JsonResult<Void> addComment(Integer orderId, Integer productId,String content, HttpSession session) {
        //String username = getUsernameFromSession(session);
        Integer uid = getUidFromSession(session);
        if(uid==null)
        {
            throw new UsernameNotFoundException();
        }
        orderService.addComment(orderId,productId, uid, content);
        return new JsonResult<>(OK);
    }
}
