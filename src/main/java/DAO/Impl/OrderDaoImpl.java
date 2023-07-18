package DAO.Impl;

import DAO.OrderDao;
import Util.DBUtil;
import pojo.OrderDetails;
import pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean deductMoney(OrderDetails orderDetails, Users users) {
        String sql = "select price from products where products.id = ?";
        String sql01 = "update users set balance = ? where id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql01)){
            preparedStatement.setInt(1,orderDetails.getProductId());
            ResultSet resultSet = preparedStatement.executeQuery();
            Float prices = 0f;
            if(resultSet.next()){
                prices = resultSet.getFloat("price");
            }
            float totalPrices = (float) prices * orderDetails.getQuantity();
            float currentMoney = users.getBalance();
            if((currentMoney - totalPrices) > 0){
                users.setBalance(currentMoney - totalPrices);
                preparedStatement1.setFloat(1,users.getBalance());
                preparedStatement1.setFloat(2,users.getId());
                preparedStatement1.execute();
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public OrderDetails getOrderDetailsById(int id) {
        String sql = "select * from order_details where id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new OrderDetails(resultSet.getInt("id"),resultSet.getInt("user_id"),resultSet.getInt("product_id"),resultSet.getInt("quantity"),resultSet.getString("order_status"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        String sql = "select * from order_details";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                OrderDetails orderDetailsTmp = new OrderDetails(resultSet.getInt("id"), resultSet.getInt("user_id"),resultSet.getInt("product_id"),resultSet.getInt("quantity"),resultSet.getString("order_status"));
                orderDetailsList.add(orderDetailsTmp);
            }
            return orderDetailsList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderDetails> getOrderDetails(int userId) {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        String sql = "select * from order_details where user_id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                OrderDetails orderDetailsTmp = new OrderDetails(resultSet.getInt("id"), resultSet.getInt("user_id"),resultSet.getInt("product_id"),resultSet.getInt("quantity"),resultSet.getString("order_status"));
                orderDetailsList.add(orderDetailsTmp);
            }
            return orderDetailsList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addOrder(OrderDetails orderDetails) {
        String sql = "insert into order_details (user_id, product_id, order_status, quantity) VALUES (?,?,?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,orderDetails.getUserId());
            preparedStatement.setInt(2,orderDetails.getProductId());
            preparedStatement.setString(3,orderDetails.getOrderStatus());
            preparedStatement.setInt(4,orderDetails.getQuantity());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOrder(OrderDetails orderDetails) {
        String sql = "update order_details set order_status = ? where id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,orderDetails.getOrderStatus());
            preparedStatement.setInt(2,orderDetails.getId());
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOrder(OrderDetails orderDetails) {
        String sql = "delete from order_details where id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,orderDetails.getId());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
