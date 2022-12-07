/**
 * 
 */
package synchronization.tcp;
	
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;
/**
 * @author SAMSUNG
 *
 */
public class ClientTCP {
		 public static void main(String[] args) throws Exception{
		        Socket clientSocket = null;
		        BufferedReader inFromServer = null;
		           // start the "timer"
		            long startTimeInMillis = System.currentTimeMillis();
		            
		            clientSocket = new Socket("192.168.0.15",9090);
		             
		            new DataOutputStream(clientSocket.getOutputStream());
		            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		            
		            String serverResponse = inFromServer.readLine();
		            System.out.println("Server's response: " + serverResponse);
		            long serverTimeInMillis = Long.parseLong(serverResponse.trim()); 

		            // stop the "timer" and caculate RTT
		            long endTimeInMillis = System.currentTimeMillis();
		            long calculatedClientTime = (endTimeInMillis - startTimeInMillis) / 2 + serverTimeInMillis;
		            Calendar newClientTime = Calendar.getInstance();
		            newClientTime.setTimeInMillis(calculatedClientTime);

		            System.out.println("calculated Client Time in Milliseconds is: " + calculatedClientTime);
		            System.out.println("calculated Client Time is: " + newClientTime.getTime());

		            clientSocket.close();
		        
		    }
		}



