package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详情表：存放订单的具体信息，包括商品id，商品数量
 * @author te9uila
 * @since 2023/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    /**
     * 订单id
     */
    private int id;
    /**
     * 订单所属用户id
     */
    private int userId;
    /**
     * 商品id
     */
    private int productId;
    /**
     * 商品数量
     */
    private int quantity;
    /**
     * 订单状态
     */
    private String orderStatus;
}
