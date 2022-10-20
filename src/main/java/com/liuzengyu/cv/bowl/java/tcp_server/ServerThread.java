package com.liuzengyu.cv.bowl.java.tcp_server;

import java.io.InputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    InputStream inputStream;
    public  ServerThread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try {
            while (true){
                inputStream=socket.getInputStream();
                byte[] bytes = new byte[1024];
                inputStream.read(bytes);
                String string = new String(bytes);
                System.out.println(string);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}