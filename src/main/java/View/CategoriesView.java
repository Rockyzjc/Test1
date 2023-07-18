package View;

import Service.CategoriesService;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class CategoriesView {
    public Scanner sc = new Scanner(System.in);
    public void categoriesView(){
        System.out.println("分类管理");
        System.out.println("1. 添加分类");
        System.out.println("2. 删除分类");
        System.out.println("3. 返回上一级页面");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 添加分类
                new CategoriesService().addCategory();
                categoriesView();
                break;
            case "2":
                // 删除分类
                new CategoriesService().deleteCategory();
                categoriesView();
                break;
            case "3":
                new AdminView().adminView();
                break;
            default:
                System.out.println("输入内容不符，重新输入");
                categoriesView();
        }
    }
}
