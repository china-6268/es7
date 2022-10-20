package com.liuzengyu.cv.bowl.tcp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ServerThread extends Thread {
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {
            //Reading the input from Client
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            
            //returning the output to the client : true statement is to flush the buffer otherwise
            //we have to do it manuallyy
             output = new PrintWriter(socket.getOutputStream(),true);


            //inifite loop for server
            while(true) {
//                InputStream is = socket.getInputStream();	//获取到客户端的输入流
//                byte[] b = new byte[1024];	//定义字节数组
//                int len = is.read(b);	//由于信息的传输是以二进制的形式，所以要以二进制的形式进行数据的读取
//                String data = new String(b, 0,len);
//                System.out.println("客户端发来消息：" + data);
                if(input.readLine()==null) {
                    System.out.println("Server ended! ");
                    break;
                }
                String outputString = input.readLine();
                outputString=outputString+" CAMCF 你好";
                //if user types exit command
                if(outputString.equals("exit")) {
                    break;
                }
                printToALlClients(outputString);
                output.println("服务端返回（Server says）： " + outputString);
                System.out.println("Server received " + outputString);
            }


        } catch (Exception e) {
            System.out.println("Error occured thread " +e.getStackTrace() +"\n"+e.getMessage());
        }
    }

    private void printToALlClients(String outputString) {
        for( ServerThread sT: threadList) {
            sT.output.println(outputString);
        }

    }
}
