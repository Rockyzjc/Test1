package DAO;

import pojo.Address;

import java.util.List;

/**
 * 地址操作接口
 * @author te9uila
 * @since 2023/7/17
 */
public interface AddressDao{
    /**
     * 根据用户id获取地址集合
     * @param userId 用户id
     * @return 返回该用户的地址对象集合
     */
    List<Address> getAddresses(int userId);

    /**
     * 上传封装好的地址
     * @param address 封装好的地址对象
     * @return 是否上传地址成功
     */
    boolean setAddress(Address address);

    /**
     * 删除封装好的地址
     * @param address 封装好的地址对象
     * @return 是否删除地址成功
     */
    boolean deleteAddress(Address address);
}
