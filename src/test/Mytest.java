package test;

import domain.Customer;
import domain.Order;
import mapper.CustomerMapper;
import mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.List;

public class Mytest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrders = orderMapper.getAllOrders();
        for (Order order : allOrders) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.getOrderWithId(1);
        System.out.println(order.getOrder_name());
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Order order = new Order();
        order.setOrder_name("新订单001");
        order.setOrder_num("200000010001");

        Customer customer = new Customer();
        customer.setCust_name("新客户001");
        customer.setCust_profession("程序猿001");
        customer.setCust_phone("13123145610");
        customer.setEmail("5454888@qq.com");

        order.setCustomer(customer);
        /*先添加客户  获取客户生成的ID  再添加订单*/
        customerMapper.insertCustomer(customer);
        System.out.println(customer);
        /*保存订单*/
        orderMapper.insertOrder(order);
        System.out.println(order);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allCustomers = customerMapper.getAllCustomers();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer);
        }
        sqlSession.close();
    }

    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Customer customer = new Customer();
        customer.setCust_name("新客户");

        Order order1 = new Order();
        order1.setOrder_name("订单2");

        Order order2 = new Order();
        order2.setOrder_name("订单2");

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        //保存数据
        customerMapper.insertCustomer(customer);
        orderMapper.insertOrder(order1);
        orderMapper.insertOrder(order2);
        
        //更新关系
        for (Order order : customer.getOrders()) {
            orderMapper.updateCustId(order.getOrder_id(),customer.getCust_id());
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        //一对多删除操作，表结构有外键约束时，需要先把表之间的外键约束关系打破
        orderMapper.updateRelationCustomer(36);
        //删除客户
        customerMapper.deleteCustomer(19);

        sqlSession.commit();
        sqlSession.close();
    }
}
