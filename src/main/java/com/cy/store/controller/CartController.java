package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
        cartService.addToCart(
                getUidFromSession(session),
                pid,
                amount,
                getUsernameFromSession(session));
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("delete_to_cart")
    public JsonResult<Void> deleteToCart(Integer cid, HttpSession session) {
        cartService.deleteToCart(cid);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        List<CartVO> data = cartService.getVOByUid(getUidFromSession(session));
        return new JsonResult<List<CartVO>>(OK, data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer data = cartService.addNum(
                cid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<Integer>(OK, data);
    }

    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> deleteNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer data = cartService.reducenum(
                cid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<Integer>(OK, data);
    }
    @RequestMapping("list")
    public JsonResult<List<CartVO>> findVOByCids(Integer[] cids, HttpSession session) {
        List<CartVO> data = cartService.getVOByCids(getUidFromSession(session), cids);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("delete")
    public JsonResult<Void> delete(HttpSession session) {
        Integer uid = getUidFromSession(session);
        cartService.deleteall(uid);

        return new JsonResult<>(OK);
    }


}
