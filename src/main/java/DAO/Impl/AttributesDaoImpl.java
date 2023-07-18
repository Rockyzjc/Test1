package DAO.Impl;

import DAO.AttributesDao;
import Util.DBUtil;
import pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class AttributesDaoImpl implements AttributesDao {
    @Override
    public Attributes getAttributesByName(String name) {
        String sql = "select * from attributes where name = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Attributes(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("category_id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Attributes,String> getAttributes(int productId) {
        Map<Attributes,String> attributesMap = new HashMap<>();
        String sql = "select attributes.*,attribute_values.description from attributes,attribute_values where attributes.id = attribute_values.attribute_id and attribute_values.product_id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                attributesMap.put(new Attributes(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("category_id")),resultSet.getString("description"));
            }
            return attributesMap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean setAttributeToCategory(Categories categories, String name) {
        String sql = "insert into attributes (category_id, name) VALUES (?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,categories.getId());
            preparedStatement.setString(2,name);
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean setAttributeValueToProduct(Products products,Attributes attributes,String description) {
        String sql = "insert into attribute_values (attribute_id, product_id, description) VALUES (?,?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,attributes.getId());
            preparedStatement.setInt(2,products.getId());
            preparedStatement.setString(3,description);
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAttribute(String attributeName) {
        Attributes attributes = getAttributesByName(attributeName);
        String sql1 = "delete from attribute_values where attribute_id = ?";
        String sql2 = "delete from attributes where id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement01 = connection.prepareStatement(sql1);
            PreparedStatement preparedStatement02 = connection.prepareStatement(sql2);){
            preparedStatement01.setInt(1,attributes.getId());
            preparedStatement01.execute();
            preparedStatement02.setInt(1,attributes.getId());
            preparedStatement02.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
