package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 属性表：每个分类都有自己独有的几个属性，此表存储单一属性信息
 * @author te9uila
 * @since 2023/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attributes {
    /**
     * 属性表id
     */
    private int id;
    /**
     * 属性名
     */
    private String name;
    /**
     * 该属性所属的分类 id
     */
    private int categoriesId;
}
