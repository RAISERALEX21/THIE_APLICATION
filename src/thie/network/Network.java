package thie.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.StrictMode;
@SuppressLint("NewApi") public class Network extends Activity{
//@SuppressLint("NewApi") public class Network extends AsyncTask<Void, Void, Void>{
	
	Socket s;
	PrintWriter out;
	BufferedReader in;
	private String mensaje_estatus;
	
	

	//ENTRADA DE DATOS
	public Network(String ip,String puerto,String idUsuario,String assistencia){
		System.out.println("constructor network");
		 
		 System.out.println("fin constructor network");
		 

			try{
				if (android.os.Build.VERSION.SDK_INT > 9) {
		  		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		  		      StrictMode.setThreadPolicy(policy);
		  		    }
				DataInputStream entrada;
				
				
				System.out.println("DATO ID : " + idUsuario);
				System.out.println("puerto:" + puerto + " ip " + ip);
				
				s= new Socket(ip,Integer.valueOf(puerto));
				s.setSoTimeout(5000);
		        
		        if(s.isConnected()){
		            System.out.println("Confirmando conexion al server....");  
		            
		            DataOutputStream mensaje = new DataOutputStream(s.getOutputStream());
		            
		            //Validación de entrada de usuario y salida.!
		            if(assistencia.equals("true")){
		            		
		            			mensaje.writeUTF(idUsuario + " | " + assistencia + "\n"); 
		            			mensaje.flush();
		            			
		            }else if(assistencia.equals("false")){
		            		
		            		    mensaje.writeUTF(idUsuario + " | " + assistencia + " \n");
		            		    mensaje.flush();
		            		    
		            }
		            	
		            System.out.println(idUsuario + " | " + assistencia + "\n");
		            	
		            //try{
		            	//MENSAJES DE ENTRADA
		            	//ENTRADA EXITOSA
		            	//SALIDA EXITOSA
		                entrada = new DataInputStream(s.getInputStream());
		                 System.out.println("Los datos son: " + entrada.readUTF());

		                 if(entrada.equals("java.io.DataInputStream@4283cff8")){
		                	 System.out.println("Se valida que ya esta registrado");
		                 }else{
		                	 System.out.println("Se valida que no esta registrado");

		                 }

		                             
		        } // FIN s.isConnected()   
		        System.out.println("fin conexion al server....");
		        
		    } catch (Exception ex) {
		        System.out.println("Error al conectar cliente " + ex.toString());
		        ex.printStackTrace();
		    }finally{
		       if(s!=null){
		            try {
		                s.close();	
		            } catch (Exception ex) {
		                System.out.println("Error al cerrar el socket");
		            }
		       }
		    }  
	}
	
	public String getMensaje() {
		return mensaje_estatus;
	}

	public void setMensaje(String mensaje_estatus) {
		this.mensaje_estatus = mensaje_estatus;
	}


}
