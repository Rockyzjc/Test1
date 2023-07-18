package DAO;

import pojo.Categories;

import java.util.List;

/**
 * @author te9uila
 * @since 2023/7/17
 */
public interface CategoriesDao {
    /**
     * 返回分类集合
     * @return 返回所有分类
     */
    List<Categories> getCategoriesList();

    /**
     * 根据分类名，获得分类对象
     * @param name 分类名
     * @return 返回该分类名对应的分类对象
     */
    Categories getCategories(String name);

    /**
     * 上传分类
     * @param categories 封装好的分类对象
     * @return 是否上传分类成功
     */
    boolean setCategory(Categories categories);

    /**
     * 删除分类，注意删除分类的同时，已经绑定该分类的商品以及绑定该商品的属性的处理
     * @param categories 封装好的分类对象
     * @return 是否删除分类成功
     */
    boolean deleteCategory(Categories categories);
}
