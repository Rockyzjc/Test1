package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息表：存储用户个人信息，包括用户名，用户密码，账户余额
 * @author te9uila
 * @since 2023/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    /**
     * 用户id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 是否为管理员
     * 值为 0 表示不是管理员
     * 值为 1 表示是管理员
     */
    private int isAdmin;
    /**
     * 账户余额
     */
    private float balance;
}
