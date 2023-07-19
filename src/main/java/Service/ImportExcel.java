package Service;

import Util.Product;
import Util.ProductListener;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/19
 */
public class ImportExcel {
    public Scanner sc = new Scanner(System.in);

    public void importExcel(){
        System.out.println("输入要导入的文件");
        System.out.println("表头请使用以下格式");
        System.out.println("分类id\t商品名\t商品描述\t商品价格\n");
        String filePath = sc.nextLine();
        File file = new File(filePath);
        // 获取文件名 和后缀C:\Users\zjc\Desktop\22.xlsx
        String[] split = file.getName().split("\\.");
        if (!file.exists()) {
            System.out.println("文件不存在");
        }else if (!split[split.length-1].equals("xlsx")){
            System.out.println("文件格式不正确");
        }else {
            try (FileInputStream fis = new FileInputStream(file);) {
                EasyExcel.read(fis, Product.class, new ProductListener())
                        .excelType(ExcelTypeEnum.XLSX)
                        .sheet(0)
                        .headRowNumber(1)
                        .doRead();
            } catch (Exception e) {

            }
        }
    }
}
