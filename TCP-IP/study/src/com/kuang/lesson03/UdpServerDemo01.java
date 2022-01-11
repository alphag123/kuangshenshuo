package com.kuang.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//还是要等待客户端的连接
public class UdpServerDemo01 {

    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//接收

        socket.receive(packet);

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        //关闭连接
        socket.close();
    }

}

