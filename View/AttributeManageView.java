package View;

import Service.AttributeManageService;

import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class AttributeManageView {
    public Scanner sc = new Scanner(System.in);
    public void attributeManageView(){
        System.out.println("属性管理页面");
        System.out.println("1. 给分类添加新的属性");
        System.out.println("2. 删除分类下的某一个属性");
        System.out.println("3. 返回上级目录");
        String tmp = sc.nextLine();
        switch (tmp){
            case "1":
                // 给分类添加新的属性
                new AttributeManageService().addNewAttributeToCategory();
                attributeManageView();
                break;
            case "2":
                // 删除分类下的某一个属性
                new AttributeManageService().deleteAttributeFromCategory();
                attributeManageView();
                break;
            case "3":
                new AdminView().adminView();
                break;
            default:
                System.out.println("输入内容不符，重新输入");
                attributeManageView();
        }
    }
}
