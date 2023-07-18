package Util;

import DAO.Impl.ProductDaoImpl;
import DAO.ProductDao;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import pojo.Products;

/**
 * @author te9uila
 * @since 2023/7/19
 */
public class ProductListener implements ReadListener<Product> {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public void invoke(Product product, AnalysisContext analysisContext) {
        System.out.println(product);
        Products products = new Products();
        products.setDescription(product.getDescription());
        products.setName(product.getName());
        products.setCategoryId(product.getCategoryId());
        products.setPrice(product.getPrice());
        productDao.addProduct(products);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("导入完成");
    }
}
