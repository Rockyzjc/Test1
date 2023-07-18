package Service;

import DAO.Impl.AttributesDaoImpl;
import DAO.Impl.CategoriesDaoImpl;
import pojo.Categories;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class AttributeManageService {
    public Scanner sc = new Scanner(System.in);
    public void addNewAttributeToCategory(){
        System.out.println("输入需要添加属性的分类");
        String category = sc.nextLine();
        Categories categoryTmp = new CategoriesDaoImpl().getCategories(category);
        System.out.println("输入添加的新的属性名称");
        String name = sc.nextLine();
        if(new AttributesDaoImpl().setAttributeToCategory(categoryTmp,name)){
            System.out.println("属性添加成功，记得为商品单独添加属性值");
        }else{
            System.out.println("属性添加失败！");
        }
    }

    public void deleteAttributeFromCategory(){
        System.out.println("输入需要删除的属性名称");
        String name = sc.nextLine();
        if(new AttributesDaoImpl().deleteAttribute(name)){
            System.out.println("属性删除成功！");
        }else{
            System.out.println("属性删除失败！");
        }
    }
}
