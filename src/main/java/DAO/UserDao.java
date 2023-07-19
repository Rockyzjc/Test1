package DAO;

import pojo.Users;

import java.util.List;

/**
 * 用户操作接口
 * @author te9uila
 * @since 2023/7/17
 */
public interface UserDao {
    /**
     * 返回整个用户集合
     * @return 返回整个用户集合
     */
    List<Users> getUserList();

    /**
     * 通过用户名获得用户对象
     * @param name 用户名
     * @return 获得的用户对象
     */
    Users getUser(String name);

    /**
     * 判断用户对象是否为管理员
     * @param users 判断是否为管理员的用户对象
     * @return 是否为管理员
     */
    boolean isAdmin(Users users);

    /**
     * 判断指定用户对象是否存在
     * @param userName 判断是否存在的用户名
     * @return 是否存在
     */
    boolean isExist(String userName);

    /**
     * 根据用户名更新密码
     * @param newPassword 新密码
     * @param userName 需要更新的用户名
     * @return 是否更新成功
     */
    boolean updatePassword(String newPassword, String userName);

    /**
     * 用户登录操作
     * @param users 进行登录操作的用户对象
     * @return 是否登录成功
     */
    boolean userLogin(Users users);

    /**
     * 用户注册操作
     * @param users 进行注册操作的用户对象
     * @return 是否注册成功
     */
    boolean userRegister(Users users);

    /**
     * 注销用户操作
     * @param users 进行注销操作的用户对象
     * @return 是否注销成功
     */
    boolean userCancel(Users users);

    /**
     * 设置用户为管理员
     * @param users 提升为管理员的用户对象
     * @return 设置管理员是否成功
     */
    boolean setAdmin(Users users);

    /**
     * 撤销用户管理员身份
     * @param users 撤销管理员身份的用户对象
     * @return 撤销管理员是否成功
     */
    boolean dropAdmin(Users users);

    /**
     * 根据用户对象的充值操作
     * @param users 需要充值的用户对象
     * @param money 充值的金额
     * @return 充值之后的用户余额
     */
    float balanceRecharge(Users users,float money);
}
