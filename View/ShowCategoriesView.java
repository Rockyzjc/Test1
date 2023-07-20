package View;

import DAO.Impl.CategoriesDaoImpl;
import DAO.Impl.ProductDaoImpl;
import Service.CategoriesService;
import pojo.Categories;
import pojo.Products;
import pojo.Users;

import java.util.List;
import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class ShowCategoriesView {
    public Scanner sc = new Scanner(System.in);
    public void showCategoriesView(Users users){
        System.out.println("所有分类如下");
        new CategoriesService().showCategories();
        System.out.println("输入你要查看的分类");
        String name = sc.nextLine();
        Categories categories = new CategoriesDaoImpl().getCategories(name);
        System.out.println("此分类对应的商品");
        List<Products> productsList = new ProductDaoImpl().showProducts(categories.getId());
        for (Products products : productsList) {
            System.out.println(products.toString());
        }
        System.out.println("1. 下单！");
        System.out.println("2. 返回上级页面");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 下单
            case "2":
                new PurchaseView().purchaseView(users);
                break;
            default:
                System.out.println("←_← 你输的介是个嘛");
                showCategoriesView(users);
        }
    }
}
