package mapper;

import domain.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.tools.ant.taskdefs.condition.Or;

import java.util.List;

public interface OrderMapper {
    //查询所有订单
    public List<Order> getAllOrders();

    //根据ID查询订单
    public Order getOrderWithId(Integer id);

    //保存订单
    public void insertOrder(Order order);

    //一对多分布查询，根据cust_id查询订单
    public Order getOrderWithCustId(Integer id);

    //更新订单表与客户表的关系 cust_id
    public void updateCustId(@Param("orderId") Integer orderId, @Param("custId") Integer custId);

    //打破与客户表的关系
    public void updateRelationCustomer(Integer custId);
}
