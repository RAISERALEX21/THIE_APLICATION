package app.jbb_alex.thie;

import thie.alumno.Index_alumno;
import thie.configuracion.Settings_THIE;
import thie.prospecto.Index_prospecto;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ConexionMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conexion_main);
	}
	
	public void index_alumno(View view){
		Intent lanzar = new Intent(ConexionMainActivity.this,Index_alumno.class);
		startActivity(lanzar);
	}
	
	//BUTTON PROSPECTOS
	
	public void index_prospecto(View view){
		Intent lanzar = new Intent(ConexionMainActivity.this,Index_prospecto.class);
		startActivity(lanzar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_thie, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.config:
			L_conexion();
		break;
		
		case R.id.acercaDe:
			
		break;
		
		}
		return false;
	}
	
	
	//LANZAR SETTINGS ACTIVIDADES 
	public void L_conexion(){
		Intent lanzar_config = new Intent(ConexionMainActivity.this,Settings_THIE.class);
		startActivity(lanzar_config);
	}
}
