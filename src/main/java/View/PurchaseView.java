package View;

import Service.SearchProductService;
import pojo.Users;

import java.util.Scanner;

/**
 * 商品选购
 * @author te9uila
 * @since 2023/7/18
 */
public class PurchaseView {
    public Scanner sc = new Scanner(System.in);
    public void purchaseView(Users users){
        System.out.println("要干什么");
        System.out.println("1. 搜索商品");
        System.out.println("2. 查看所有商品");
        System.out.println("3. 返回上一个界面");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 根据商品名搜索商品
                new SearchProductService().searchProductService(users);
                break;
            case "2":
                // 查看所有商品
                new ShowCategoriesView().showCategoriesView(users);
                break;
            case "3":
                // 返回上一个界面
                new FirstView().firstView(users);
                break;
            default:
                System.out.println("←_← 你输的介是个嘛");
                purchaseView(users);
        }
    }
}
