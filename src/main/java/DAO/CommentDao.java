package DAO;

import pojo.Comment;

import java.util.List;

/**
 * 评论操作接口
 * @author te9uila
 * @since 2023/7/17
 */
public interface CommentDao {
    /**
     * 根据商品id获得评论集合
     * @param productId 商品id
     * @return 该商品id的集合
     */
    List<Comment> getComments(int productId);

    /**
     * 上传评论
     * @param comment 封装好的评论对象
     * @return 是否上传评论成功
     */
    boolean addComments(Comment comment);

    /**
     * 删除评论
     * @param comment 封装好的评论对象
     * @return 是否删除评论成功
     */
    boolean deleteComments(Comment comment);
}
