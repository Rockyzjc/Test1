package View;

import Service.UserService;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class RegisterView {
    public void registerView(){
        System.out.println("注册页面");
        // 注册的service
        if(new UserService().registerService()){
            // 注册成功
            new LoginView().loginView();
        }else{
            // 注册失败
            new StartView().startView();
        }
    }
}
