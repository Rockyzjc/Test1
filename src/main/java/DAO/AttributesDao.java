package DAO;

import pojo.AttributeValues;
import pojo.Attributes;
import pojo.Categories;
import pojo.Products;

import java.util.Map;

/**
 * @author te9uila
 * @since 2023/7/17
 */
public interface AttributesDao {
    /**
     * 根据属性名返回属性对象
     * @param name 属性名
     * @return 该属性名的属性对象
     */
    Attributes getAttributesByName(String name);

    /**
     * 根据商品获得属性集合
     * @param productId 商品id
     * @return 获得的属性对象以及其对应的属性值
     */
    Map<Attributes,String> getAttributes(int productId);

    /**
     * 给分类添加新的属性
     * @param categories 需要添加新属性的分类
     * @param name 添加的新属性名称
     * @return 是否添加商品属性成功
     */
    boolean setAttributeToCategory(Categories categories,String name);

    /**
     * 给商品添加属性值
     * @param products 需要添加新属性值的商品
     * @param attributes 添加的新属性id
     * @param description 该属性的属性值
     * @return 是否添加商品属性值成功
     */
    boolean setAttributeValueToProduct(Products products,Attributes attributes,String description);

    /**
     * 根据属性名删除商品属性，注意删除此属性时，同时需要处理已经绑定该属性的商品
     * @param attributeName 属性名
     * @return 是否删除成功
     */
    boolean deleteAttribute(String attributeName);
}
