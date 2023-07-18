package DAO;

import pojo.OrderDetails;
import pojo.Users;

import java.util.List;

/**
 * 订单操作接口
 * @author te9uila
 * @since 2023/7/17
 */
public interface OrderDao {
    /**
     * 模拟扣款
     * @param orderDetails 进行模拟支付的订单对象
     * @param users 需要进行模拟支付的用户对象
     * @return 是否扣款成功
     */
    boolean deductMoney(OrderDetails orderDetails, Users users);

    /**
     * 返回所有订单
     * @return 返回订单集合
     */
    List<OrderDetails> getAllOrderDetails();

    /**
     * 根据订单id获取订单对象
     * @param id 订单id
     * @return 订单对象
     */
    OrderDetails getOrderDetailsById(int id);

    /**
     * 根据用户id获得订单
     * @param userId 用户id
     * @return 该用户的订单集合
     */
    List<OrderDetails> getOrderDetails(int userId);

    /**
     * 添加订单（提前封装对象）
     * @param orderDetails 添加的订单对象
     * @return 是否添加订单成功
     */
    boolean addOrder(OrderDetails orderDetails);

    /**
     * 删除订单
     * （tips:先通过getOrder拉取订单集合，手动获取订单对象，再删除该订单）
     * @param orderDetails 删除的订单对象
     * @return 是否删除订单成功
     */
    boolean deleteOrder(OrderDetails orderDetails);

    /**
     * 更新订单状态，例如：未支付 => 已支付
     * （tips:先通过getOrder拉取订单集合，手动获取订单对象，更改订单 orderStatus属性，更新订单对象）
     * @param orderDetails 需要更新订单状态的订单对象
     * @return 是否更新订单成功
     */
    boolean updateOrder(OrderDetails orderDetails);
}
