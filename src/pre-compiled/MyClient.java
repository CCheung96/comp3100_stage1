import java.net.*;
import java.io.*;
class MyClient{
	public static void main(String args[])throws Exception{
		Socket s=new Socket("localhost",50000);

		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

		try{
			String request = "";
			String response = "";

			dout.writeUTF("HELO");
			dout.flush();
			response=din.readUTF();  
			System.out.println("Server says: "+response);  

			while(!response.equals("BYE")){  

				if (response.equals("G'DAY"))
				{
					request = "BYE";
					dout.writeUTF(request);  
					dout.flush();  
					response=din.readUTF();  
					System.out.println("Server says: "+response);  
				}
			}  
	} catch (Exception e){
		e.printStackTrace();
		//System.exit();
	}
	
	}
}
