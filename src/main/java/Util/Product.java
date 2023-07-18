package Util;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zjc
 * @since 2023/7/19
 */
@Data
public class Product {
    /**
     * 所属分类对应id
     */
    @ExcelProperty("分类id")
    private int categoryId;
    /**
     * 商品名
     */
    @ExcelProperty("商品名")
    private String name;
    /**
     * 商品描述
     */
    @ExcelProperty("商品描述")
    private String description;
    /**
     * 商品价格
     */
    @ExcelProperty("商品价格")
    private BigDecimal price;
}