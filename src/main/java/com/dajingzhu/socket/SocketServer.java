package com.dajingzhu.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private static ServerSocket SERVER_SOCKET = null;;

	static {
		try {
			SERVER_SOCKET = new ServerSocket(45678);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			System.out.println("******服务器已启动，等待客户端连接*****");
			Socket socket = null;
			while (true) {
				// 循环监听客户端的连接
				socket = SERVER_SOCKET.accept();
				InetAddress address = socket.getInetAddress();
				System.out.println(address);

				// ApplicationContext context = new
				// ClassPathXmlApplicationContext("classpath:applicationContext.xml");
				// 新建一个线程ServerSocket，并开启
				new ServerSocketThread(socket).start();
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
