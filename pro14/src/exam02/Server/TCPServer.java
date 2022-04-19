package exam02.Server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPServer {

	public static void main(String[] args) {
		try {
			/*
			 * 1. 네트워크 통신을 위한 IP 주소 정보 설정
			 */
			byte[] addr = new byte[] {(byte)192, (byte)168, (byte)0, (byte)13};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 50000;
			
			/*
			 * 2. 서버용 소켓 생성 후 서버IP, 서버Port 바인딩
			 */
			ServerSocket serverSock = new ServerSocket();
			InetSocketAddress serverIpPort = new InetSocketAddress(serverIp, serverPort);
			serverSock.bind(serverIpPort);
			
			/*
			 * 3. 클라이언트 요청을 대기 후 승낙(accept)하여 클라이언트용 소켓 생성
			 */
			Socket sock = serverSock.accept();
			
			/*
			 * 4. 통신용 입출력 스트림 생성
			 */
			BufferedReader sIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter sOut = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			while(sIn.ready()) {
				String line = sIn.readLine();
				System.out.println(line);
			}
			
			/*
			 * 5. 모든 데이터 수신을 완료하였으면 모든 자원 반납.
			 */
			sIn.close();
			sOut.close();
			sock.close();
			serverSock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
}

