package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

	// 传入连接到客户端的Socket
	Socket s = null;
	// 从socket中得到的输入流
	BufferedReader br = null;

	public ServerThread(Socket socket) throws IOException {
		this.s = socket;
		br = new BufferedReader(new InputStreamReader(s.getInputStream(),
				"utf-8"));
	}

	public void run() {
		while (true) {
			// 向服务器中保存的所有的客户端socket发送消息
			try {
				String content = null;
				while ((content = readFromSocket()) != null) {
					for (Socket s : SimpleServer.list) {
						// 获得该socket的输出流
						OutputStream os = s.getOutputStream();
						os.write((content + "\n").getBytes("utf-8"));

					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public String readFromSocket() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			// 如果捕捉到异常，说明改Socket对饮的客户端已经关闭
			System.out.println("socket:"+s.toString()+"已退出");
			SimpleServer.list.remove(s);
	

		}
		return null;

	}

}
