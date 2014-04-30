package thie.configuracion;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.jbb_alex.thie.R;

public class Settings_THIE extends Activity{
	
	protected EditText eText_desbloq, eText_port,eText_ip, eText_usuario, eText_frec, eText_notf;
	protected Button acep_desblop, acep_confnet, cance_confnet, pass_accedeer;
	
	Context ctx;
	
	public Settings_THIE(){}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_settings_thie);
		ctx = this.getApplication().getApplicationContext();
		
		
		//Mis variables
	
		String prefer = "", mi_ip = "", desbloq= "";
		String notifi = "", frecc = "";
		int user_id = 0, puerto = 0;
		
		//Var con sus OB**********************************************
		
		//RED___________
		eText_desbloq = (EditText) findViewById(R.id.pass_desbloquear);
		eText_usuario = (EditText) findViewById(R.id.id_alumno);
		eText_ip      = (EditText) findViewById(R.id.ip_network);
		eText_port    = (EditText) findViewById(R.id.puerto_netwok);
		
		//NOTIFICACION_
		eText_frec    = (EditText) findViewById(R.id.nf_frecuencia);
		eText_notf    = (EditText) findViewById(R.id.nf_tiempoAviso);
		//ButAcep______
		acep_confnet  = (Button) findViewById(R.id.butt_aceptar_net);
		
		
		//Bloqueando VAR**********************************************
		//eText_desbloq.setEnabled(false);
		eText_usuario.setEnabled(false);
		eText_ip.setEnabled(false);
		eText_port.setEnabled(false);
		eText_frec.setEnabled(false);
		eText_notf.setEnabled(false);
		
		acep_confnet.setEnabled(false);
		
		//Tomar datos*************************************************
		SharedPreferences conf = ctx.getSharedPreferences("datos_conf", Context.MODE_PRIVATE);
		
		desbloq  = conf.getString("desbloq","");
		user_id  = conf.getInt("id_usuario", 0);
		mi_ip    = conf.getString("ip","" );
		puerto   = conf.getInt("port", 0);
		
		notifi   = conf.getString("notifi", "");
		frecc    = conf.getString("frecc", "");
	
		
		System.out.println("DATOS: desbloquear/ " + desbloq + " ID/" + user_id + " IP/ " + mi_ip + " PUERTO/ "  + puerto + " FRECC/ " + frecc + " NOTIFICACION/ " + notifi);
		
		//-___-_- CONECTAR CON EDIT TEXT
		
			
			eText_desbloq.setText(desbloq);
			eText_usuario.setText(String.valueOf(user_id));
			eText_ip.setText("" + mi_ip);
			eText_port.setText("" + puerto);
			eText_frec.setText("" + frecc);
			eText_notf.setText("" + notifi);
		
	}
	
	
	
	

     public String getShareProperties(String id_property,Context ctx){
		//Tomar datos
				SharedPreferences conf = ctx.getSharedPreferences("datos_conf", Context.MODE_PRIVATE);
				String property = "";
				if(id_property.contains("usuario") || id_property.contains("port"))
				  property = String.valueOf(conf.getInt(id_property,0));
				else{
					 property = conf.getString(id_property,"");
				}
				
				return property;
		
	}
     
     public void But_pass(View view){
    	 
    	 String pass_check = eText_desbloq.getText().toString();
    	 try{
    	 if(  pass_check.equals("")  ){
    		 
    		 Toast.makeText(this, "Por favor introduzca el Password.", Toast.LENGTH_SHORT).show();
    		 
    	 }else if( !pass_check.equals("pc1234")){
    		 
    		 Toast.makeText(this, "Verifique la contraseña", Toast.LENGTH_SHORT).show();
    		 
    	 }else if( pass_check.equals("pc1234")){
    		 
    		 Toast.makeText(this, "Acceso correcto", Toast.LENGTH_LONG).show();
    		 
    		 eText_desbloq.setEnabled(true);
    		 eText_usuario.setEnabled(true);
    		 eText_ip.setEnabled(true);
    		 eText_port.setEnabled(true);
    		 eText_frec.setEnabled(true);
    		 eText_notf.setEnabled(true);
    		 acep_confnet.setEnabled(true);
    		 cance_confnet.setEnabled(true);
    		 
    	 }
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
    	 
     }
     
     public void aceptar_settings(View v){
 		
 		SharedPreferences preferencias = ctx.getSharedPreferences("datos_conf",Context.MODE_PRIVATE);
 		Editor editor = preferencias.edit();
 		
 		//editor.putString("datos_conf", eText_desbloq.getText().toString());
 		
 	   //editor.putString("desbloq",eText_usuario.getText().toString());
 		
 		if(eText_usuario.equals("")){
 			
 		}
 		
 		editor.putString("id_usuario",eText_usuario.toString() + "|true");
 		editor.putInt("id_usuario", Integer.valueOf(eText_usuario.getText().toString()));
 		editor.putString("ip", eText_ip.getText().toString());
 		editor.putInt("port", Integer.valueOf(eText_port.getText().toString()));
 		editor.putInt("frecc", Integer.valueOf(eText_frec.getText().toString()));
 		editor.putInt("notf", Integer.valueOf(eText_notf.getText().toString()));
 		editor.commit();
 		finish();
 		
 	}
}
