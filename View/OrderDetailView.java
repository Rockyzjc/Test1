package View;

import DAO.Impl.OrderDaoImpl;
import Service.OrderManageService;
import pojo.OrderDetails;
import pojo.Users;

import java.util.List;
import java.util.Scanner;

/**
 * 订单详情
 * @author te9uila
 * @since 2023/7/18
 */
public class OrderDetailView {
    public Scanner sc = new Scanner(System.in);
    public void orderDetailView(Users users){
        List<OrderDetails> orderDetailsList=new OrderDaoImpl().getOrderDetails(users.getId());
        System.out.println("你的所有订单如下：");
        for (OrderDetails orderDetails:orderDetailsList) {
            System.out.println(orderDetails.toString());
        }
        System.out.println("1. 模拟订单付款");
        System.out.println("2. 返回上级页面");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 模拟订单付款
                new OrderManageService().deductMoney(users);
                break;
            case "2":
                // 返回上级页面
                new FirstView().firstView(users);
                break;
            default:
                System.out.println("←_← 你输的介是个嘛");
                orderDetailView(users);
        }
    }
}
