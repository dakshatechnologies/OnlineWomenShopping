package com.JSON.ows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.neww.HomeFragment;
import com.example.neww.Productlist;





import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class Webservices {
	
	
	public List<NameValuePair> nameValuePairs;
	public Context context;
	public String id=null; 
	public List<String> Name_EthnicWear;
	public List<String> Price_EthnicWear;
	public List<String> Specialprice_EthnicWear;
	public List<String> Image_EthnicWear;
	public String result = "";
	public String OutputData = "";
	
	public String mEthnicwear(Context homeFragment, String url2)
	{
		context=homeFragment;
		id="EthnicWear";
		Name_EthnicWear=new ArrayList<String>();
		Price_EthnicWear=new ArrayList<String>();
		Specialprice_EthnicWear=new ArrayList<String>();
		Image_EthnicWear=new ArrayList<String>();
		return dataparse(url2);
		
	}
	
	String dataparse(final String url)
	{
	 new Parsing().execute(url);
	 return result;
	}
	
	public class Parsing extends AsyncTask<String, String,String>
	{
		HttpResponse response;
		InputStream inputstream;
		
		private ProgressDialog Dialog = new ProgressDialog(context);
		
		@Override
		protected void onPreExecute() {
			
			super.onPreExecute();
			 Dialog.setMessage("Please wait..");
			 Dialog.setCanceledOnTouchOutside(false);
	         Dialog.show();
	         
		}

		@Override
		protected String doInBackground(String... arg0) {
			
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost httppost=new HttpPost(arg0[0]);
			
			switch (id) {
			case "EthnicWear":
				nameValuePairs=new ArrayList<NameValuePair>(1);
				nameValuePairs.add(new BasicNameValuePair("", ""));
				Log.v("run", "run");
				break;

			default:
				nameValuePairs.add(new BasicNameValuePair("testing", "testing"));
				break;
			}
			
			try
			{
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			}
			catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			
			try
			{
			response=httpClient.execute(httppost);
			inputstream=response.getEntity().getContent();
            if(inputstream != null)
            {
             result = convertInputStreamToString(inputstream);
            Log.d("result", result);
			}
            else
                result = "Did not work!";
           Log.d("Http Response:", response.toString()+ result);
			}
			catch(ClientProtocolException e)
			{
			e.printStackTrace();	
			}
			catch (IOException e) {
			e.printStackTrace();
			}
			
			return result;
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			
			String resultdata=" " ;
			String Name=" ";
			String Price=" ";
			String SpecialPrice=" ";
			String Image_address=" ";
			
            JSONObject jsonResponse;
            
            try {
                
                /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                jsonResponse = new JSONObject(result);
                  
                /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
                /*******  Returns null otherwise.  *******/
                JSONArray jsonMainNode = jsonResponse.optJSONArray("items");
                  
                /*********** Process each JSON Node ************/

                int lengthJsonArr = jsonMainNode.length();  

                for(int i=0; i < lengthJsonArr; i++) 
                {
                    /****** Get Object for each JSON node.***********/
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                    
                    switch (id) {
					case "EthnicWear":
						
						Name = jsonChildNode.optString("name").toString();
						Price = jsonChildNode.optString("price").toString();
						SpecialPrice = jsonChildNode.optString("special_price").toString();
						Image_address = jsonChildNode.optString("image").toString();
						Name_EthnicWear.add(Name);
						Price_EthnicWear.add(Price);
						Specialprice_EthnicWear.add(SpecialPrice);
						Image_EthnicWear.add(Image_address);
						Log.e("getimage",Image_EthnicWear.toString());
						break;

					default:
						Toast.makeText(context, "wrong keyfeatching", 1000).show();
						break;
					}
			
                    OutputData=resultdata;
			
		}
              //Show Parsed Output on screen (activity)
                
                if(id.equalsIgnoreCase("EthnicWear"))
                {
               	 Datastore.getInstance().set_Name_ethnicwear(Name_EthnicWear);
               	 Datastore.getInstance().set_Price_ethnicwear(Price_EthnicWear);
               	 Datastore.getInstance().set_SpecialPrice_ethnic_wear(Specialprice_EthnicWear);
              // 	 Datastore.getInstance().set_Imageaddress_ethnicwear(Image_EthnicWear);
               	 Datastore.getInstance().set_Imageaddress_ethnicwear(Image_EthnicWear);
               	 Log.e("Sucess", "Sucess");
               	 
               	 Toast.makeText(context, "check", 1000).show();
               	 
               	Intent io=new Intent(context,Productlist.class);
				context.startActivity(io);
                }
	
		
            Dialog.dismiss();
            Log.d("RESULT", OutputData);
            }
		 catch (JSONException e) {
            
            Log.v("PARSING", e.toString());
        }
		}
            private String convertInputStreamToString(InputStream inputStream) throws IOException{
    	        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
    	        String line = "";
    	        String result = "";
    	        while((line = bufferedReader.readLine()) != null)
    	            result += line;
    	 
    	        inputStream.close();
    	        return result;
    	 
    	    }
	}

	
}
