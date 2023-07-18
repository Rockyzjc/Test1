package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址信息表：存储收货信息，包括收货人，电话以及收货地址
 * @author te9uila
 * @since 2023/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    /**
     * 地址id
     */
    private int id;
    /**
     * 用户表对应id
     */
    private int userId;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 收货人电话
     */
    private String phone;
    /**
     * 收货人地址
     */
    private String address;
}
