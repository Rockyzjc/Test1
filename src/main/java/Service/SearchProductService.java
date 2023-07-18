package Service;

import DAO.Impl.OrderDaoImpl;
import DAO.Impl.ProductDaoImpl;
import View.PurchaseView;
import pojo.OrderDetails;
import pojo.Products;
import pojo.Users;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/19
 */
public class SearchProductService {
    public Scanner sc = new Scanner(System.in);

    public void addOrder(Products products,Users users){
        System.out.println("输入你要下单的产品数量");
        String tmp = sc.nextLine();
        int quantity = 0;
        try{
            quantity = Integer.parseInt(tmp);
        }catch(Exception e){
            System.out.println("输入正确的产品数量");
            addOrder(products,users);
        }
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setUserId(users.getId());
        orderDetails.setQuantity(quantity);
        orderDetails.setOrderStatus("未付款");
        orderDetails.setProductId(products.getId());
        new OrderDaoImpl().addOrder(orderDetails);
        System.out.println("成功下单");
        new PurchaseView().purchaseView(users);
    }

    public void searchProductService(Users users){
        System.out.println("输入你要查找的商品");
        String name = sc.nextLine();
        Products products = new ProductDaoImpl().getProduct(name);
        if(products == null){
            System.out.println("找不到此商品");
        }else{
            System.out.println("1. 下单");
            System.out.println("2. 退回上级页面");
            String tmp = sc.nextLine();
            switch (tmp){
                case "1":
                    // 下单
                    addOrder(products,users);
                    break;
                case "2":
                    new PurchaseView().purchaseView(users);
                    break;
                default:
                    System.out.println("←_← 你输的介是个嘛");
                    searchProductService(users);
            }
        }
    }
}
