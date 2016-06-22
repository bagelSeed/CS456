import java.io.*;
import java.net.*;

class Client {
	public static void main(String []args) throws Exception {
		System.out.println("Client Initilization...");

		// Predetermine the port number that the server is listening to
		Integer tcpPort = 6666;
		Integer udpPort = 9999;

		byte[] sendData = new byte[1024];
		DatagramSocket udpClientSocket = new DatagramSocket();
		// InetAddress serverIPAddr = InetAddress.getByName("localhost");
		InetAddress serverIPAddr = InetAddress.getByAddress("ubuntu1204-002/129.97.167.41".getBytes());
		sendData = "WE GOT MESSAGE SON!".getBytes();
		DatagramPacket udpSendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddr, udpPort);
		udpClientSocket.send(udpSendPacket);

		System.out.println("Client sent message.");
	}
}