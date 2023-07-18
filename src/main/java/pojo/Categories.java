package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分类表：包括分类名，分类描述
 * @author te9uila
 * @since 2023/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    /**
     * 分类id
     */
    private int id;
    /**
     * 分类名
     */
    private String name;
    /**
     * 分类描述
     */
    private String description;
}
