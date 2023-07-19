package DAO.Impl;

import DAO.UserDao;
import Util.DBUtil;
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
public class UserDaoImpl implements UserDao {
    @Override
    public List<Users> getUserList() {
        List<Users> usersList = new ArrayList<>();
        String sql = "select * from users";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                usersList.add(new Users(resultSet.getInt("id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getInt("isAdmin"),resultSet.getFloat("balance")));
            }
            return usersList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public float balanceRecharge(Users users, float money) {
        String sql = "update users set balance = balance + ? where username = ?";
        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setFloat(1,money);
            ps.setString(2,users.getUsername());
            ps.execute();
            users.setBalance(new UserDaoImpl().getUser(users.getUsername()).getBalance());
        }catch (Exception e){
            e.printStackTrace();
        }
        return users.getBalance();
    }

    @Override
    public Users getUser(String name) {
        String sql = "select * from users where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Users(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("isAdmin"), resultSet.getFloat("balance"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isAdmin(Users users) {
        String sql = "select isAdmin from users where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,users.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("isAdmin") == 1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isExist(String userName) {
        String sql = "select * from users where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                // 查到同名数据
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePassword(String newPassword, String userName) {
        // 没有找到需要改密码的用户
        if (!isExist(userName)){
            return false;
        }
        // 数据库中存在需要改密码的用户
        String sql = "update users set PASSWORD = ? where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,userName);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean userLogin(Users users) {
        // 没有找到需要登录的用户名
        if (!isExist(users.getUsername())){
            return false;
        }
        // 找到需要登录的用户名，开始确认密码
        String sql = "select password from users where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,users.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if (users.getPassword().equals(resultSet.getString("password"))){
                    return true;
                }else{
                    return false;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean userRegister(Users users) {
        // 发现有同名数据，不进行注册操作
        if(isExist(users.getUsername())){
            return false;
        }
        // 没有同名数据，可以进行注册操作
        String sql = "insert into users (username, password, isAdmin, balance) value (?,?,?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2,users.getPassword());
            preparedStatement.setInt(3,users.getIsAdmin());
            preparedStatement.setFloat(4,users.getBalance());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean userCancel(Users users) {
        // 发现有没有同名数据，不进行注销操作
        if(!isExist(users.getUsername())){
            return false;
        }
        String sql = "delete from users where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean setAdmin(Users users) {
        // 发现没有同名数据，不进行提升管理员操作
        if(!isExist(users.getUsername())){
            return false;
        }
        String sql = "update users set isAdmin = 1 where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean dropAdmin(Users users) {
        // 发现没有同名数据，不进行降权操作
        if(!isExist(users.getUsername())){
            return false;
        }
        String sql = "update users set isAdmin = 0 where username = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
