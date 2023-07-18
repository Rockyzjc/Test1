package com.ierb.repeatRobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author te9uila
 * @since 2023/7/19
 */
public class RepeatRobot {
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server started. Waiting for client connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            out.println("你好");
            out.flush();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("用户: " + inputLine);

//                 从控制台读取服务器端的消息并发送给客户端
                String serverMessage = consoleReader.readLine();
                out.println(serverMessage);
            }

            in.close();
            out.close();
            consoleReader.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
