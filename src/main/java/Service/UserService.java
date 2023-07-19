package Service;

import DAO.Impl.UserDaoImpl;
import DAO.UserDao;
import pojo.Users;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class UserService {
    public Users usersUltimate;
    public Scanner sc = new Scanner(System.in);

    public boolean registerService(){
        System.out.println("输入用户名");
        String username = sc.nextLine();
        System.out.println("输入密码");
        String password = sc.nextLine();
        System.out.println("确认密码");
        String passwordTmp = sc.nextLine();
        if(!passwordTmp.equals(password)){
            System.out.println("行不行啊，这也能输错~~~");
            return false;
        }else {
            Users users = new Users();
            users.setUsername(username);
            users.setPassword(password);
            if(new UserDaoImpl().userRegister(users)){
                System.out.println("注册成功！");
                return true;
            }else{
                System.out.println("注册失败！");
                return false;
            }
        }
    }

    /**
     * @return 1 -> 管理员身份登录成功   0 -> 登录失败    -1 -> 普通用户身份登录成功
     */
    public int loginService(){
        System.out.println("输入用户名");
        String username = sc.nextLine();
        System.out.println("输入密码");
        String password = sc.nextLine();
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        if(new UserDaoImpl().userLogin(users)){
            // 登录成功
            if(new UserDaoImpl().isAdmin(users)){
                // 是管理员身份
                System.out.println("管理员" + users.getUsername() + "大人,欢迎你！");
                return 1;
            }else {
                // 不是管理员
                usersUltimate = users;
                System.out.println(users.getUsername() + "自己爬进去！");
                return -1;
            }
        }else {
            return 0;
        }
    }

    /**
     * 输出所有用户信息
     */
    public void showUsers(){
        List<Users> usersList = new UserDaoImpl().getUserList();
        for (Users users : usersList) {
            System.out.println(users.toString());
        }
    }

    public void updateUsers(){
        showUsers();
        System.out.println("输入需要提权的用户名");
        String name = sc.nextLine();
        if(new UserDaoImpl().setAdmin(new UserDaoImpl().getUser(name))){
            System.out.println("用户提权成功");
        }else {
            System.out.println("用户提权失败，确认有没有该用户");
        }
    }

    public void reduceUsers(){
        showUsers();
        System.out.println("输入需要降权的用户名");
        String name = sc.nextLine();
        if(new UserDaoImpl().dropAdmin(new UserDaoImpl().getUser(name))){
            System.out.println("管理员降权成功");
        }else{
            System.out.println("管理员降权失败，你到底想不想降权啊，淦");
        }
    }

    public void deleteUser(){
        showUsers();
        System.out.println("输入需要删除的用户名");
        String name = sc.nextLine();
        Users userTmp = new UserDaoImpl().getUser(name);
        if(new UserDaoImpl().isAdmin(userTmp)){
            System.out.println("删同行这不好叭。。。。");
            return;
        }
        if(new UserDaoImpl().userCancel(userTmp)){
            System.out.println("用户删除成功");
        }else{
            System.out.println("用户删除失败");
        }
    }
}
