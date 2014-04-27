package thie.alumno;

import java.util.concurrent.ExecutionException;

import thie.configuracion.Settings_THIE;
import thie.db_multimedia.Thie_conexion_multimedia;
import thie.network.Network;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import app.jbb_alex.thie.R;

public class Index_alumno extends Activity{
	
	private CheckBox chk_entrada, chk_salida;
	private Button sync;
	private Network conexion;
	private String chk_assist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index_alumno);
		
		addAsistencia_Chk_entrada();
		addAsistencia_Chk_salida();
		
		
	}
	
	public void addAsistencia_Chk_entrada(){
		
		chk_entrada = (CheckBox)findViewById(R.id.check_entrada);
		
		chk_entrada.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				
				if(((CheckBox)view).isChecked()){
					Toast.makeText(Index_alumno.this, "Generando conexión....", Toast.LENGTH_SHORT).show();
					
					try{
						
						Toast.makeText(Index_alumno.this, "Comenzando conexión..!!", Toast.LENGTH_SHORT).show();
						Settings_THIE settings = new Settings_THIE();
						String idusuario = settings.getShareProperties("id_usuario", view.getContext());
						String ip = settings.getShareProperties("ip", view.getContext());
						String puerto = settings.getShareProperties("port", view.getContext());
						
						System.out.println("seteo propiedades para network index_alumno");
						
						conexion = new Network(ip,puerto,idusuario, chk_assist= "true");
						
						if(conexion.getClass().toString().equals("ya existe registro entrada")){
						
							chk_entrada.setEnabled(false);
							
						}else{
							try {
								//conexion.get
								chk_entrada.setEnabled(false);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						
						}
						
						
					}catch(Exception e){
						
						Toast.makeText(Index_alumno.this, "Problemas de conexión, validar configuración de conexión." + e,  Toast.LENGTH_SHORT).show();
						e.printStackTrace();
						
					}	
				}
			}
		});
	}
	//AGREGANDO MIS BUTTONS
	public void addAsistencia_Chk_salida(){
		
		chk_salida  = (CheckBox)findViewById(R.id.check_salida);
		
		chk_salida.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View view){
				
				if(((CheckBox)view).isChecked()){
					
					Toast.makeText(Index_alumno.this, "Comenzando conexión..!!", Toast.LENGTH_SHORT).show();
					Settings_THIE settings = new Settings_THIE();
					String idusuario = settings.getShareProperties("id_usuario", view.getContext());
					String ip = settings.getShareProperties("ip", view.getContext());
					String puerto = settings.getShareProperties("port", view.getContext());
					
					chk_assist = "false";
					System.out.println("seteo propiedades para network index_alumno");
					
					conexion = new Network(ip,puerto,idusuario,chk_assist);
					System.out.println("Mensaje get:" + conexion.getMensaje());
					try {
						//conexion.get();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 

					chk_salida.setEnabled(false);
				}
				
			}
			
		});
		
	}

	public void but_notificaciones(View view){
		Intent lanzar = new Intent(Index_alumno.this,Thie_notificaciones.class);
		startActivity(lanzar);
	}
	
	public void but_multimedia(View view){
		Intent lanzar = new Intent(Index_alumno.this,Thie_multimedia.class);
		startActivity(lanzar);
	}
	
	public void Sync_JSON(View view){
		
		sync = (Button)findViewById(R.id.button_sync_1);
		
		sync.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View view){
				
				Thie_conexion_multimedia mult = new Thie_conexion_multimedia();
				
				
			}
			
		});
		
	}

}
