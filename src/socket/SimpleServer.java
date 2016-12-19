package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleServer {
	public static ArrayList<Socket> list = new ArrayList<Socket>();

	public static void main(String[] args) {
		// 创建一个ServerSocket，用于建厅客户端的请求
		try {

			ServerSocket ss = new ServerSocket(23456);
			System.out.println("服务器创建啦！");
			while (true) {
				Socket socket = ss.accept();
				System.out.println("有客户端连接上服务器啦");
				list.add(socket);
				// 新启动一条服务器线程为客户端服务
				new Thread(new ServerThread(socket)).start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
