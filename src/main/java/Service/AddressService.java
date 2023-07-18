package Service;

import DAO.Impl.AddressDaoImpl;
import pojo.Address;
import pojo.Users;

import java.util.List;
import java.util.Scanner;

/**
 * @author te9uila
 * @since 2023/7/18
 */
public class AddressService {
    public Scanner sc = new Scanner(System.in);

    public void showAddresses(Users users){
        List<Address> addressList = new AddressDaoImpl().getAddresses(users.getId());
        for (Address address : addressList) {
            System.out.println(address.toString());
        }
    }

    public void addAddress(Users users){
        System.out.println("电话:");
        String phone = sc.nextLine();
        System.out.println("地址:");
        String newAddress = sc.nextLine();
        Address address=new Address();
        address.setUserId(users.getId());
        address.setConsignee(users.getUsername());
        address.setPhone(phone);
        address.setAddress(newAddress);
        new AddressDaoImpl().setAddress(address);
    }

    public void deleteAddress(Users users){
        showAddresses(users);
        System.out.println("需要删除的地址名");
        String tmp = sc.nextLine();
        Address address=new Address();
        address.setUserId(users.getId());
        address.setConsignee(users.getUsername());
        address.setAddress(tmp);
        new AddressDaoImpl().deleteAddress(address);
    }
}
