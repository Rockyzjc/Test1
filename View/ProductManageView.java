package View;

import Service.ImportExcel;
import Service.ProductService;

import java.util.Scanner;

//C:\Users\zjc\Desktop\test.xlsx

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class ProductManageView {
    public Scanner sc = new Scanner(System.in);
    public void productManageView(){
        System.out.println("商品管理页面");
        System.out.println("1. 下架商品");
        System.out.println("2. 添加商品");
        System.out.println("3. 导入商品Excel");
        System.out.println("4. 返回上一级页面");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 下架商品页面
                new ProductService().removeProduct();
                productManageView();
                break;
            case "2":
                // 添加商品页面
                new ProductService().addProduct();
                productManageView();
                break;
            case "3":
                new ImportExcel().importExcel();
                productManageView();
                break;
            case "4":
                new AdminView().adminView();
                break;
            default:
                System.out.println("输入内容不符，重新输入");
                productManageView();
        }
    }
}
