package mapper;

import domain.Customer;
import org.apache.ibatis.annotations.MapKey;

import java.security.interfaces.DSAPublicKey;
import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    //根据id获取客户
    public Customer getCustomerWithId(Integer id);

    //添加客户
    public void insertCustomer(Customer customer);

    //查询所有客户
    public List<Customer> getAllCustomers();

    //根据ID删除客户
    public void deleteCustomer(Integer id);
}
