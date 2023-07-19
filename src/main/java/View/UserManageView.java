package View;

import Service.UserService;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/19
 */
public class UserManageView {

    public Scanner sc = new Scanner(System.in);

    public void userManageView(){
        System.out.println("用户管理");
        System.out.println("1. 用户提权");
        System.out.println("2. 用户降权");
        System.out.println("3. 用户删除");
        System.out.println("4. 返回上一级目录");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 用户提权
                new UserService().updateUsers();
                userManageView();
                break;
            case "2":
                // 用户降权
                new UserService().reduceUsers();
                userManageView();
                break;
            case "3":
                // 用户删除
                new UserService().deleteUser();
                userManageView();
                break;
            case "4":
                new AdminView().adminView();
                break;
            default:
                System.out.println("输入内容不符，重新输入");
                userManageView();
        }
    }
}
