package thie.prospecto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import app.jbb_alex.thie.R;

public class Index_prospecto extends Activity{

	private Matrix mapaThie;
	private String uri = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index_prospecto);
			
	}
	
	@SuppressWarnings("null")
	public void bt_Compartir(View view){
		/*Intent i = new Intent(Intent.ACTION_SEND); i.setType("image/jpeg");    
		i.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://app.jbb_alex.thie/" + R.raw.thie_map)); 
		startActivity(Intent.createChooser(i, "Send Image"));
	*/}

}
