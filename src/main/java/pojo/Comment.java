package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品评论表
 * @author te9uila
 * @since 2023/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    /**
     * 评论id
     */
    private int id;
    /**
     * 评论所属用户id
     */
    private int userId;
    /**
     * 被评论的商品的id
     */
    private int productsId;
    /**
     * 评论具体信息
     */
    private String description;
}
