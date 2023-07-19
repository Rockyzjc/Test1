package Service;

import pojo.Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author te9uila
 * @since 2023/7/19
 */
public class ConnectService {
    public void connectService(Users users){
        // 客户端连接
        try {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Connected to server.");
            System.out.println("输入886断开连接");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("客服: " + inputLine);
                // 从控制台读取客户端的消息并发送给服务器端
                String clientMessage = consoleReader.readLine();
                out.println(clientMessage);
                if ("886".equals(clientMessage)){
                    break;
                }
            }
            in.close();
            out.close();
            consoleReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
