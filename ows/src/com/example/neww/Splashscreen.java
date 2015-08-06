package com.example.neww;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

@SuppressWarnings("deprecation")
public class Splashscreen extends ActionBarActivity{
	public ProgressBar pb ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splashscreen);
		pb=(ProgressBar)findViewById(R.id.pbsplash);
			        
			        Thread t = new Thread() {
			            public void run() {
			                 
			                try {
			                    
			                    sleep(5*1000);
			                     
			                   
			                    Intent i=new Intent(getApplicationContext(),homepage.class);
			                    startActivity(i);
			                    finish();
			                     
			            
			                     
			                } catch (Exception e) {
			                 
			                }
			            }
			        };
			        t.start();
			}

			

			
		

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splashscreen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
