package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 属性值表：每一个属性都拥有自己的属性信息
 * @author te9uila
 * @since 2023/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValues {
    /**
     * 主键id，没有特殊意义
     */
    private int id;
    /**
     * 属性id
     */
    private int attributeId;
    /**
     * 商品id
     */
    private int productsId;
    /**
     * 该属性的值
     */
    private String description;
}
