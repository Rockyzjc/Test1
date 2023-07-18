package Service;

import DAO.Impl.ProductDaoImpl;
import pojo.Products;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class ProductService {
    public Scanner sc = new Scanner(System.in);
    public void showProduct(){
        List<Products> productsList = new ProductDaoImpl().showAllProducts();
        for (Products products : productsList) {
            System.out.println(products.toString());
        }
    }

    public void removeProduct(){
        showProduct();
        System.out.println("输入需要删除的商品名");
        String tmp = sc.nextLine();
        Products products = new ProductDaoImpl().getProduct(tmp);
        try{
            if(new ProductDaoImpl().dropProduct(products)){
                System.out.println("商品下架成功！");
            }else{
                System.out.println("商品下架失败！");
            }
        }catch(Exception e){
            System.out.println("下架商品失败！");
        }
    }

    public void addProduct(){
        System.out.println("输入需要添加的商品名");
        String name = sc.nextLine();
        System.out.println("输入需要添加的商品描述");
        String description = sc.nextLine();
        System.out.println("输入需要添加的商品价格");
        int price = 0;
        try{
            price = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("输入参数有误，重新输入");
            addProduct();
            return;
        }
        Products productsTmp = new Products();
        productsTmp.setName(name);
        productsTmp.setDescription(description);
        productsTmp.setPrice(BigDecimal.valueOf(price));
        if(new ProductDaoImpl().addProduct(productsTmp)){
            System.out.println("添加商品成功！");
        }else{
            System.out.println("添加商品失败！");
        }
    }
}
