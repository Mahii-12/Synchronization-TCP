/**
 * 
 */
package synchronization.tcp;

/**
 * @author SAMSUNG
 *
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
	
public class ServerTCP {
	 
     public static void main(String[] args) {
		        ServerSocket serverSocket = null;
		        Socket socket = null;
		        try {
		            serverSocket = new ServerSocket(9090);
		            System.out.println("Server is running...");
		            while (true) {
		                socket = serverSocket.accept();

		                System.out.println("New connection from " + socket.getInetAddress().getHostAddress());

		                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
		                String serverTime = getServerTime();
		                System.out.println(serverTime);

		                outToClient.writeBytes(serverTime);
		                socket.close();
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    private static String getServerTime() {
		        Calendar cal = Calendar.getInstance();
		        Date date = cal.getTime();
		        long timeInMillis = date.getTime(); 
		        System.out.println(date);
		        return String.valueOf(timeInMillis);
		    }
		}	
		



