import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
 
public class RemoteDroidServer {
	
	private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 1996;
 
	public static void main(String[] args) {
		boolean leftpressed=false;
		boolean rightpressed=false;
 
	    try{
	    		robot = new Robot();
			server = new ServerSocket(SERVER_PORT); //Create a server socket on port 8998
			client = server.accept(); //Listens for a connection to be made to this socket and accepts it
			in = new BufferedReader(new InputStreamReader(client.getInputStream())); //the input stream where data will come from client
		}catch (IOException e) {
			System.out.println("Error in opening Socket");
			System.exit(-1);
		}catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}
			
		//read input from client while it is connected
	    while(isConnected){
	        try{
			line = in.readLine(); 
			System.out.println(line); 
			
			if(line.equalsIgnoreCase("right")){
				
				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);
			}
			else if(line.equalsIgnoreCase("left")){
				
				robot.keyPress(KeyEvent.VK_LEFT);
				robot.keyRelease(KeyEvent.VK_LEFT);		        	
			}
			else if(line.equalsIgnoreCase("up")){
				
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);		        	
			}
			else if(line.equalsIgnoreCase("down")){
				
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);		        	
			}
			else if(line.equalsIgnoreCase("space")){
				
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			}
			else if(line.equalsIgnoreCase("a")){
				
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);		        	
			}
			else if(line.equalsIgnoreCase("b")){
				
				robot.keyPress(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_B);		        	
			}
			else if(line.equalsIgnoreCase("c")){
				
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);		        	
			}
			else if(line.equalsIgnoreCase("d")){
				
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);		        	
			}
			else if(line.equalsIgnoreCase("e")){
				
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E);		        	
			}
			else if(line.equalsIgnoreCase("f")){
				
				robot.keyPress(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_F);		        	
			}
			else if(line.equalsIgnoreCase("g")){
				
				robot.keyPress(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_G);		        	
			}
			else if(line.equalsIgnoreCase("h")){
				
				robot.keyPress(KeyEvent.VK_H);
				robot.keyRelease(KeyEvent.VK_H);		        	
			}
			else if(line.equalsIgnoreCase("i")){
				
				robot.keyPress(KeyEvent.VK_I);
				robot.keyRelease(KeyEvent.VK_I);		        	
			}
			else if(line.equalsIgnoreCase("j")){
				
				robot.keyPress(KeyEvent.VK_J);
				robot.keyRelease(KeyEvent.VK_J);		        	
			}
			else if(line.equalsIgnoreCase("k")){

				robot.keyPress(KeyEvent.VK_K);
				robot.keyRelease(KeyEvent.VK_K);		        	
			}
			else if(line.equalsIgnoreCase("l")){
				
				robot.keyPress(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_L);		        	
			}
			else if(line.equalsIgnoreCase("m")){
				
				robot.keyPress(KeyEvent.VK_M);
				robot.keyRelease(KeyEvent.VK_M);		        	
			}
			else if(line.equalsIgnoreCase("n")){
				
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_N);		        	
			}
			else if(line.equalsIgnoreCase("o")){
				
				robot.keyPress(KeyEvent.VK_O);
				robot.keyRelease(KeyEvent.VK_O);		        	
			}
			else if(line.equalsIgnoreCase("p")){
				
				robot.keyPress(KeyEvent.VK_P);
				robot.keyRelease(KeyEvent.VK_P);		        	
			}
			else if(line.equalsIgnoreCase("q")){
				
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_Q);		        	
			}
			else if(line.equalsIgnoreCase("r")){
				
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_R);		        	
			}
			else if(line.equalsIgnoreCase("s")){
				
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);		        	
			}
			else if(line.equalsIgnoreCase("t")){
				
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);		        	
			}
			else if(line.equalsIgnoreCase("u")){
				
				robot.keyPress(KeyEvent.VK_U);
				robot.keyRelease(KeyEvent.VK_U);		        	
			}
			else if(line.equalsIgnoreCase("v")){
				
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);		        	
			}
			else if(line.equalsIgnoreCase("w")){
				
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_W);		        	
			}
			else if(line.equalsIgnoreCase("x")){
				
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_X);		        	
			}
			else if(line.equalsIgnoreCase("y")){
				
				robot.keyPress(KeyEvent.VK_Y);
				robot.keyRelease(KeyEvent.VK_Y);		        	
			}
			else if(line.equalsIgnoreCase("z")){
				
				robot.keyPress(KeyEvent.VK_Z);
				robot.keyRelease(KeyEvent.VK_Z);		        	
			}
			else if(line.equalsIgnoreCase("backspace")){
				
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);		        	
			}
			else if(line.equalsIgnoreCase("f1")){
				
				robot.keyPress(KeyEvent.VK_F1);
				robot.keyRelease(KeyEvent.VK_F1);		        	
			}
			else if(line.equalsIgnoreCase("f2")){
				
				robot.keyPress(KeyEvent.VK_F2);
				robot.keyRelease(KeyEvent.VK_F2);		        	
			}
			else if(line.equalsIgnoreCase("f3")){
				
				robot.keyPress(KeyEvent.VK_F3);
				robot.keyRelease(KeyEvent.VK_F3);		        	
			}
			else if(line.equalsIgnoreCase("f4")){
				
				robot.keyPress(KeyEvent.VK_F4);
				robot.keyRelease(KeyEvent.VK_F4);		        	
			}
			else if(line.equalsIgnoreCase("f5")){
				
				robot.keyPress(KeyEvent.VK_F5);
				robot.keyRelease(KeyEvent.VK_F5);		        	
			}
			else if(line.equalsIgnoreCase("f6")){
				
				robot.keyPress(KeyEvent.VK_F6);
				robot.keyRelease(KeyEvent.VK_F6);		        	
			}
			else if(line.equalsIgnoreCase("f7")){
				
				robot.keyPress(KeyEvent.VK_F7);
				robot.keyRelease(KeyEvent.VK_F7);		        	
			}
			else if(line.equalsIgnoreCase("f8")){
				
				robot.keyPress(KeyEvent.VK_F8);
				robot.keyRelease(KeyEvent.VK_F8);		        	
			}
			else if(line.equalsIgnoreCase("f9")){
				
				robot.keyPress(KeyEvent.VK_F9);
				robot.keyRelease(KeyEvent.VK_F9);		        	
			}
			else if(line.equalsIgnoreCase("f10")){
				
				robot.keyPress(KeyEvent.VK_F10);
				robot.keyRelease(KeyEvent.VK_F10);		        	
			}
			else if(line.equalsIgnoreCase("f11")){
				
				robot.keyPress(KeyEvent.VK_F11);
				robot.keyRelease(KeyEvent.VK_F11);		        	
			}
			else if(line.equalsIgnoreCase("f12")){
				
				robot.keyPress(KeyEvent.VK_F12);
				robot.keyRelease(KeyEvent.VK_F12);		        	
			}
			else if(line.equalsIgnoreCase("enter")){
				
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);		        	
			}
			else if(line.equalsIgnoreCase("windows")){
				
				robot.keyPress(KeyEvent.VK_WINDOWS);
				robot.keyRelease(KeyEvent.VK_WINDOWS);		        	
			}
			else if(line.equalsIgnoreCase("one")){
				
				robot.keyPress(KeyEvent.VK_1);
				robot.keyRelease(KeyEvent.VK_1);		        	
			}
			else if(line.equalsIgnoreCase("two")){
				
				robot.keyPress(KeyEvent.VK_2);
				robot.keyRelease(KeyEvent.VK_2);		        	
			}
			else if(line.equalsIgnoreCase("three")){
				
				robot.keyPress(KeyEvent.VK_3);
				robot.keyRelease(KeyEvent.VK_3);		        	
			}
			else if(line.equalsIgnoreCase("four")){
				
				robot.keyPress(KeyEvent.VK_4);
				robot.keyRelease(KeyEvent.VK_4);		        	
			}
			else if(line.equalsIgnoreCase("five")){
				
				robot.keyPress(KeyEvent.VK_5);
				robot.keyRelease(KeyEvent.VK_5);		        	
			}
			else if(line.equalsIgnoreCase("six")){
				
				robot.keyPress(KeyEvent.VK_6);
				robot.keyRelease(KeyEvent.VK_6);		        	
			}
			else if(line.equalsIgnoreCase("seven")){
				
				robot.keyPress(KeyEvent.VK_7);
				robot.keyRelease(KeyEvent.VK_7);		        	
			}
			else if(line.equalsIgnoreCase("eight")){
				
				robot.keyPress(KeyEvent.VK_8);
				robot.keyRelease(KeyEvent.VK_8);		        	
			}
			else if(line.equalsIgnoreCase("nine")){
				
				robot.keyPress(KeyEvent.VK_9);
				robot.keyRelease(KeyEvent.VK_9);		        	
			}
			else if(line.equalsIgnoreCase("zero")){
				
				robot.keyPress(KeyEvent.VK_0);
				robot.keyRelease(KeyEvent.VK_0);		        	
			}
			//input will come in x,y format if user moves mouse on mousepad
			else if(line.contains(",")){
				float movex=Float.parseFloat(line.split(",")[0]);//extract movement in x direction
				float movey=Float.parseFloat(line.split(",")[1]);//extract movement in y direction
				Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
				float nowx=point.x;
				float nowy=point.y;
				robot.mouseMove((int)(nowx+movex),(int)(nowy+movey));//Move mouse pointer to new location
			}
			//if user taps on mousepad to simulate a left click
			else if(line.contains("left_click")){
				//Simulate press and release of mouse button 1(makes sure correct button is pressed based on user's dexterity)
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			else if(line.contains("rc")){
				//Simulate press and release of mouse button 1(makes sure correct button is pressed based on user's dexterity)
				//System.out.println("Hello click received");
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
			}
			//Exit if user ends the connection
			else if(line.equalsIgnoreCase("exit")){
				isConnected=false;
				//Close server and client socket
				server.close();
				client.close();
			}
	        } catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }
      	}
	}
}
