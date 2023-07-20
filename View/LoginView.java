package View;

import DAO.Impl.UserDaoImpl;
import Service.UserService;
import pojo.Users;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class LoginView {

    public void loginView(){
        System.out.println("登录页面");
        UserService userService = new UserService();
        // 调用登录方法
        switch (userService.loginService()){
            case 1:
                // 管理员身份登录成功
                new AdminView().adminView();
                break;
            case 0:
                // 登录失败
                new StartView().startView();
                break;
            case -1:
                // 普通用户身份登录成功
                Users users = new UserDaoImpl().getUser(userService.usersUltimate.getUsername());
                new FirstView().firstView(users);
            default:
        }

    }
}
