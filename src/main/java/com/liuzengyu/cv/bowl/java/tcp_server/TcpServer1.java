package com.liuzengyu.cv.bowl.java.tcp_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer1 {

    private ServerSocket server;	//设置服务器套接字
    private Socket client;		//设置客户端套接字

    private Socket socket;
    private int port=12000;
    //连接客户端函数
    void getServer()
    {
//        while (1==1) {
        int i=0;
            try {
                server = new ServerSocket(port);    //建立服务器 端口为1100
//                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("服务器建立成功！正在等待连接......");
                while (true){
//                    while (true) {
//                        Socket socket = serverSocket.accept();

                        // read data from the client
                        // send data to the client
//                    }
                    socket=server.accept();//有连接会返回一个Socket,其作为参数传给服务端线程类
                    System.out.println("client successed ！");
                    client = server.accept();    //调用服务器函数对客户端进行连接
                    System.out.println("客户端连接成功！ip为：" + client.getInetAddress());//返回客户端IP
                    System.out.println("port "+client.getPort());
                    getClientMessage();        //调用信息传输和接收函数
                    i++;
                    System.out.println(i);
//                    new ServerThread(socket).start();//有新的连接就建立一个对应的线程
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
//    }

    void getClientMessage()
    {
        try {
            while (1==1) {
                InputStream is = client.getInputStream();	//获取到客户端的输入流
                byte[] b = new byte[1024];	//定义字节数组
                int len = is.read(b);	//由于信息的传输是以二进制的形式，所以要以二进制的形式进行数据的读取
                String data = new String(b, 0,len);
                System.out.println("客户端发来消息：" + data);

                //定义发送给客户端的输出流
                OutputStream put = client.getOutputStream();
                String putText = "我已经收到！欢迎你！";
                put.write(putText.getBytes());	//将输出流信息以二进制的形式进行写入

            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        try {
            //判断客户端字节流不是空，则关闭客户端
            if (server != null) {
                server.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TcpServer1 myTcp = new TcpServer1();	//调用该类生成对象
        myTcp.getServer();	//调用方法
    }

}
