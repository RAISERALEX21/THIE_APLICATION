package thie.db_multimedia;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;



	
	public class Thie_conexion_multimedia extends AsyncTask<String,Integer,Boolean>{
		
		String tabla;
		String num_e;
		
		@Override
		protected Boolean doInBackground(String... params){
			
			boolean resul = true;
			try{
			HttpClient httpClient = new DefaultHttpClient();
			//String id = params[0];
				//HttpGet del = new HttpGet("http://followheel.ohkasystems.com/middleware/services/catalogo/modelos");
			HttpGet del = new HttpGet("http://192.168.0.2:8084/ThinkInEnglishWeb/listMultimediaByAlumno_Android.do?idalumno=3");
			del.setHeader("content-type","application/json");
			
			
				HttpResponse resp = httpClient.execute(del);
				String respStr = EntityUtils.toString(resp.getEntity());
				
				
				
				System.out.println("jSON MY OBJECT" + respStr); 
				
				JSONObject respJSON = new JSONObject(respStr);
				
				num_e = respJSON.getString("numelements");
				tabla = respJSON.getString("multimedias");
				
				
			}catch(Exception ex){
				
				Log.e("ServiceRest", "ERROR CONEXION!",ex);
				resul = false;
				
			}
			return resul;
			
		}
		
		@Override
		protected void onPostExecute(Boolean result){
			
			if(result){
				System.out.println(" RESP: " + num_e + tabla);
			}
			
		}
		
	}

