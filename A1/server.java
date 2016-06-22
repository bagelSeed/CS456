import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class Server {
	public static void main(String []args) throws Exception {
		System.out.println("Server Initilization...");
		System.out.println("Server IP: " + InetAddress.getLocalHost());

		// Predetermine the port number that the server is listening to
		Integer tcpPort = 6666;
		Integer udpPort = 9999;

		byte[] receiveData = new byte[1024];

		// UDP Socket
		DatagramSocket udpSocket = new DatagramSocket(udpPort);
		System.out.println("Server listening on uPort: " + udpPort);
		
		
		while (true) {
			DatagramPacket udpPacket = new DatagramPacket(receiveData, receiveData.length);
			udpSocket.receive(udpPacket);
			System.out.println("Server recieves UDP packet");

			receiveData = udpPacket.getData();
			String str = new String(receiveData, StandardCharsets.UTF_8);
			System.out.println("Recieved String: " + str);
		}
	}
}