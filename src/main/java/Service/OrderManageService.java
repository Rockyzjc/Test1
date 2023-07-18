package Service;

import DAO.Impl.OrderDaoImpl;
import View.OrderDetailView;
import pojo.OrderDetails;
import pojo.Users;

import java.util.List;
import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class OrderManageService {
    public Scanner sc = new Scanner(System.in);

    public void showOrder(){
        List<OrderDetails> orderDetailsList = new OrderDaoImpl().getAllOrderDetails();
        for (OrderDetails orderDetails : orderDetailsList) {
            System.out.println(orderDetails.toString());
        }
    }

    public void simulatedDelivery(){
        try{
            System.out.println("输入需要发货的订单id");
            int tmp = Integer.parseInt(sc.nextLine());
            OrderDetails orderDetails = new OrderDaoImpl().getOrderDetailsById(tmp);
            orderDetails.setOrderStatus("已发货");
            if(new OrderDaoImpl().updateOrder(orderDetails)){
                System.out.println("发货成功");
            }else {
                System.out.println("发货失败");
            }
        }catch (Exception e){
            System.out.println("发货失败");
        }
    }
    public void deductMoney(Users users){
        System.out.println("输入需要付款的订单id");
        String tmp = sc.nextLine();
        int orderId = 0;
        try{
            orderId = Integer.parseInt(tmp);
        }catch(Exception e){
            System.out.println("输入正确的订单id");
            deductMoney(users);
        }
        new OrderDaoImpl().deductMoney(new OrderDaoImpl().getOrderDetailsById(orderId),users);
        OrderDetails orderDetails = new OrderDaoImpl().getOrderDetailsById(orderId);
        orderDetails.setOrderStatus("已支付");
        new OrderDaoImpl().updateOrder(orderDetails);
        System.out.println("付款成功！");
        new OrderDetailView().orderDetailView(users);
    }
}
