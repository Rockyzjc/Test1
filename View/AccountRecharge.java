package View;

import pojo.Users;

import java.util.Scanner;

/**
 * 账户充值
 * @author te9uila
 * @since 2023/7/18
 */
public class AccountRecharge {
    public Scanner sc = new Scanner(System.in);

    public void accountRecharge(Users users){
        System.out.println("账户充值");
        System.out.println("请输入充值金额");
        String tmp = sc.nextLine();
        try{
            float addMoney = Float.parseFloat(tmp);
        }catch(Exception e){
            System.out.println("输入正确的充值金额");
            accountRecharge(users);
        }
        // 充值service

    }
}
