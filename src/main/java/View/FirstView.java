package View;

import Service.ConnectService;
import pojo.Users;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class FirstView {
    public Scanner sc = new Scanner(System.in);

    public void firstView(Users users) {
        System.out.println("普通用户主界面：");
        System.out.println("1.商品选购");
        System.out.println("2.订单详情");
        System.out.println("3.收获地址管理");
        System.out.println("4.账户充值");
        System.out.println("5.联系客服");
        System.out.println("6.返回上一级目录");
        String tmp = sc.nextLine();
        switch (tmp) {
            case "1":
                // 商品选购
                new PurchaseView().purchaseView(users);
                break;
            case "2":
                // 订单详情
                new OrderDetailView().orderDetailView(users);
                break;
            case "3":
                // 收获地址管理
                new AddressManagementView().addressManagementView(users);
                break;
            case "4":
                // 账户充值
                new AccountRecharge().accountRecharge(users);
                break;
            case "5":
                // 联系客服
                new ConnectService().connectService(users);
                System.out.println("客服费用就不收你的了，帮你关个系统算了");
                System.exit(0);
                break;
            case "6":
                // 返回上一级目录
                new StartView().startView();
                break;
            default:
                System.out.println("←_← 你输的介是个嘛");
                firstView(users);
        }

    }
}
