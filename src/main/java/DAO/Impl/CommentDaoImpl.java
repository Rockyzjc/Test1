package DAO.Impl;

import DAO.CommentDao;
import Util.DBUtil;
import pojo.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> getComments(int productId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "select * from comment where product_id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Comment comment = new Comment(resultSet.getInt("id"),resultSet.getInt("user_id"),resultSet.getInt("product_Id"),resultSet.getString("description"));
                comments.add(comment);
            }
            return comments;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addComments(Comment comment) {
        String sql = "insert into comment (user_id, product_id, description) VALUES (?,?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,comment.getUserId());
            preparedStatement.setInt(2,comment.getProductsId());
            preparedStatement.setString(3,comment.getDescription());
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteComments(Comment comment) {
        String sql = "delete from comment where id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,comment.getId());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
