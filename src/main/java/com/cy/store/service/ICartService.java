package com.cy.store.service;

import com.cy.store.vo.CartVO;

import java.util.List;

/** 处理商品数据的业务层接口 */
public interface ICartService {
    /**
     * 将商品添加到购物车
     * @param uid 当前登录用户的id
     * @param pid 商品的id
     * @param amount 增加的数量
     * @param username 当前登录的用户名
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);
    void deleteToCart(Integer cid);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * 增加用户的购物车中某商品的数量
     * @param cid
     * @param uid
     * @param username
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cid,Integer uid, String username);

    Integer reducenum(Integer cid, Integer uid, String username);

    List<CartVO> getVOByCids(Integer uid, Integer[] cids);//uid是为了判断数据归属是否正确

    void deleteall(Integer uid);
}
