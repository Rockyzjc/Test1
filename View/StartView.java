package View;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class StartView {
    public Scanner sc = new Scanner(System.in);
    public void startView(){
        System.out.println("开始菜单");
        System.out.println("1. 登录");
        System.out.println("2. 注册");
        System.out.println("3. 退出");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 登录页面
                new LoginView().loginView();
                break;
            case "2":
                // 注册页面
                new RegisterView().registerView();
                break;
            case "3":
                return;
            default:
                System.out.println("输入内容不符，重新输入");
                startView();
        }
    }
}
