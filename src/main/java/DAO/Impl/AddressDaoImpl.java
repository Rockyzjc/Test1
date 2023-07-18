package DAO.Impl;

import DAO.AddressDao;
import Util.DBUtil;
import pojo.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class AddressDaoImpl implements AddressDao {
    @Override
    public List<Address> getAddresses(int userId) {
        List<Address> addressList = new ArrayList<>();
        String sql = "select * from address where user_id = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Address addressTmp = new Address(resultSet.getInt("id"),resultSet.getInt("user_id"),resultSet.getString("consignee"),resultSet.getString("phone"),resultSet.getString("address"));
                addressList.add(addressTmp);
            }
            return addressList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean setAddress(Address address) {
        String sql = "insert into address (user_id, consignee, phone, address) VALUES (?,?,?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,address.getUserId());
            preparedStatement.setString(2,address.getConsignee());
            preparedStatement.setString(3, address.getPhone());
            preparedStatement.setString(4,address.getAddress());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAddress(Address address) {
        String sql = "delete from address where address = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,address.getAddress());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
