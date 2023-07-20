package View;

import Service.AddressService;
import pojo.Users;

import java.util.Scanner;

/**
 * 收获地址管理
 * @author te9uila
 * @since 2023/7/18
 */
public class AddressManagementView {
    public Scanner sc = new Scanner(System.in);
    public void addressManagementView(Users users){
        System.out.println("邮寄地址管理");
        System.out.println("1. 查看现有地址");
        System.out.println("2. 搬家咯，增加新地址");
        System.out.println("3. 分手，换个地方住吧");
        System.out.println("4. 回到上级页面");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 查看现有地址
                new AddressService().showAddresses(users);
                break;
            case "2":
                // 搬家咯，增加新地址
                new AddressService().addAddress(users);
                break;
            case "3":
                // 分手，换个地方住吧
                new AddressService().deleteAddress(users);
                break;
            case "4":
                // 回到上级页面
                new FirstView().firstView(users);
                break;
            default:
                System.out.println("←_← 你输的介是个嘛");
                addressManagementView(users);
        }
    }
}
