package View;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class AdminView {
    public Scanner sc = new Scanner(System.in);
    public void adminView(){
        System.out.println("管理员菜单：");
        System.out.println("1. 商品管理");
        System.out.println("2. 属性管理");
        System.out.println("3. 分类管理");
        System.out.println("4. 用户订单管理");
        System.out.println("5. 退出");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                new ProductManageView().productManageView();
                break;
            case "2":
                new AttributeManageView().attributeManageView();
                break;
            case "3":
                new CategoriesView().categoriesView();
                break;
            case "4":
                new OrderManageView().orderManageView();
                break;
            case "5":
                // 退出
                new StartView().startView();
                break;
            default:
                System.out.println("输入内容不符，重新输入");
                adminView();
        }
    }
}
