package View;

import Service.OrderManageService;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class OrderManageView {
    public Scanner sc = new Scanner(System.in);
    public void orderManageView(){
        System.out.println("用户订单管理页面");
        System.out.println("所有订单信息");
        new OrderManageService().showOrder();
        // 输出所有订单
        loop: while(true){
            System.out.println("1. 模拟发货");
            // 加模拟退货
            System.out.println("2. 返回上一级目录");
            String tmp = sc.nextLine();
            switch (tmp){
                case "1":
                    //模拟发货
                    new OrderManageService().simulatedDelivery();
                    orderManageView();
                    break loop;
                case "2":
                    new AdminView().adminView();
                    break loop;
                default:
            }
        }
    }
}
