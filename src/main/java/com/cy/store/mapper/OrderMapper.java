package com.cy.store.mapper;
import java.util.List;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    void addComment(@Param("orderId")Integer orderId,@Param("pid") Integer productId, @Param("uid")Integer uid,@Param("content") String content);
    /**
     * 插入某一个订单中商品数据
     * @param orderItem 订单中商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    List<Order> findByUid(Integer uid);

    List<OrderItem> findByOid(Integer oid);
}
