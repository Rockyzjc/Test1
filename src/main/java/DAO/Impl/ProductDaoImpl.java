package DAO.Impl;

import DAO.ProductDao;
import Util.DBUtil;
import pojo.Categories;
import pojo.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Products> showAllProducts() {
        List<Products> productsList = new ArrayList<>();
        String sql = "select * from products";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                productsList.add(new Products(resultSet.getInt("id"),resultSet.getInt("category_id"),resultSet.getString("name"),resultSet.getString("description"),resultSet.getBigDecimal("price")));
            }
            return productsList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Products> showProducts(int categoriesId) {
        List<Products> productsList = new ArrayList<>();
        String sql = "select * from products where category_id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,categoriesId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                productsList.add(new Products(resultSet.getInt("id"),resultSet.getInt("category_id"),resultSet.getString("name"),resultSet.getString("description"),resultSet.getBigDecimal("price")));
            }
            return productsList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Products getProduct(String productName) {
        String sql = "select * from products where name = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Products(resultSet.getInt("id"),resultSet.getInt("category_id"),resultSet.getString("name"),resultSet.getString("description"),resultSet.getBigDecimal("price"));
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addProduct(Products products) {
        String sql = "insert into products (category_id, name, description, price) VALUES (?,?,?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,products.getCategoryId());
            preparedStatement.setString(2,products.getName());
            preparedStatement.setString(3,products.getDescription());
            preparedStatement.setBigDecimal(4,products.getPrice());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean dropProduct(Products products){
        String sql = "delete from products where id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,products.getId());
            preparedStatement.execute();
            return true;
        }catch(Exception e){

        }
        return false;
    }
}
