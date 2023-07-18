package Service;

import DAO.Impl.UserDaoImpl;
import pojo.Users;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/19
 */
public class AccountRechargeService {
    public Scanner sc = new Scanner(System.in);

    public void accountRechargeService(Users users){
        System.out.println("输入充值金额");
        String tmp = sc.nextLine();
        float addMoney = 0f;
        try{
            addMoney = Float.parseFloat(tmp);
        }catch(Exception e){
            System.out.println("输入正确的数据");
            accountRechargeService(users);
        }
        System.out.println("充值成功！\n当前余额为：");
        System.out.println(new UserDaoImpl().balanceRecharge(users, addMoney));
    }
}
