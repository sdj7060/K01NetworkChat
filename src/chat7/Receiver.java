package chat7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class Receiver extends Thread{

	Socket socket;
	BufferedReader in = null;
	
	public Receiver (Socket socket) {
		this.socket = socket;	
		
		try {
			in = new BufferedReader(new 
					InputStreamReader(socket.getInputStream()));
		}
		catch (Exception e) {
			System.out.println("예외>Receiver>생성자:"+e);
		}
	}
	
	@Override
	public void run() {
		while (in != null) {
			try {
				System.out.println("Tread Receive : "+ in.readLine());
			}
			catch (SocketException e) {
				System.out.println("SocketException");
				break;
			}
			catch (Exception e) {
				System.out.println("예외Receiver>run1:"+e);
			}
		}
		
		try {
			in.close();
		}
		catch (Exception e) {
			System.out.println("예외Receiver>run2:"+e);
		}
	}
}
