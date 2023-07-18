package Service;

import DAO.CategoriesDao;
import DAO.Impl.CategoriesDaoImpl;
import pojo.Categories;

import java.util.List;
import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class CategoriesService {
    public Scanner sc = new Scanner(System.in);

    public void showCategories(){
        List<Categories> categoriesList = new CategoriesDaoImpl().getCategoriesList();
        for (Categories categories : categoriesList) {
            System.out.println(categories.toString());
        }
    }

    public void addCategory(){
        Categories categoryTmp = new Categories();
        System.out.println("输入需要添加的分类名");
        categoryTmp.setName(sc.nextLine());
        System.out.println("输入此分类的描述信息");
        categoryTmp.setDescription(sc.nextLine());
        if(new CategoriesDaoImpl().setCategory(categoryTmp)){
            System.out.println("分类上传成功！");
        }else{
            System.out.println("分类上传失败！");
        }
    }

    public void deleteCategory(){
        showCategories();
        System.out.println("输入需要删除的分类名");
        String name = sc.nextLine();
        Categories categoryTmp = new CategoriesDaoImpl().getCategories(name);
        if(new CategoriesDaoImpl().deleteCategory(categoryTmp)){
            System.out.println("分类删除成功！");
        }else{
            System.out.println("分类删除失败！");
        }
    }
}
