import java.net.*;
import java.io.*;
public class MyUdpServer{
public static void main(String args[]){ 
        System.out.println("starting server");
	DatagramSocket aSocket = null;
	try{
		aSocket = new DatagramSocket(6789);
		byte[] buffer = new byte[1000];
		String message = "";
		while(true){
			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(request); 
			System.out.println("request received");
			if(request.getData() == "HELO".getBytes()){
				message = "GDAY";
			}
			DatagramPacket reply = new DatagramPacket(message, request.getLength(), request.getAddress(), request.getPort());
			aSocket.send(reply);
		}
	}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
	}catch (IOException e) {System.out.println("IO: " + e.getMessage());
	}finally {if(aSocket != null) aSocket.close();}

}
}
