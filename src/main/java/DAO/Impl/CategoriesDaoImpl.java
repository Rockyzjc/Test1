package DAO.Impl;

import DAO.CategoriesDao;
import Util.DBUtil;
import pojo.Categories;
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
public class CategoriesDaoImpl implements CategoriesDao {
    @Override
    public List<Categories> getCategoriesList() {
        List<Categories> categoriesList = new ArrayList<>();
        String sql = "select * from categories";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                categoriesList.add(new Categories(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("description")));
            }
            return categoriesList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Categories getCategories(String name) {
        String sql = "select * from categories where name = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Categories(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("description"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean setCategory(Categories categories) {
        String sql = "insert into categories (name, description) VALUES (?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,categories.getName());
            preparedStatement.setString(2,categories.getDescription());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCategory(Categories categories) {
        String sql01 = "delete from categories where id = ?";
        String sql02 = "delete from products where category_id = ?";
         try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql01);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql02)){
            preparedStatement1.setInt(1,categories.getId());
            preparedStatement2.setInt(1,categories.getId());
            preparedStatement1.execute();
            preparedStatement2.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
