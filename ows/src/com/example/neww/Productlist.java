package com.example.neww;

import java.util.ArrayList;
import java.util.List;

import com.JSON.ows.Datastore;
import com.JSON.ows.Webservices;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

@SuppressWarnings("deprecation")
public class Productlist extends ActionBarActivity {

	RecyclerView recyclerView;
	ArrayList<String> Name;
	ArrayList<String> Image;
	ArrayList<String> price;

	RecycleAdapter recycleAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productlist);

		recyclerView = (RecyclerView) findViewById(R.id.rv);
		recyclerView.setHasFixedSize(false);

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		// ArrayList<String> myDataset = new ArrayList<String>();
		// for (int i= 0; i < 70; i++){
		// myDataset.add("kuldeep " + i);
		// }
		//
		// RecycleAdapter RAdapter=new
		// RecycleAdapter(getApplicationContext(),myDataset);

		Image = new ArrayList<>(Datastore.getInstance().get_Image_ethnicwear());
		Name = new ArrayList<>(Datastore.getInstance().get_Name_EthnicWear());
		price = new ArrayList<>(Datastore.getInstance().get_Price_ethnicwear());
		recycleAdapter = new RecycleAdapter(Productlist.this, Image, Name,
				price);
		Log.v("images", Image.toString());
		Log.e("Name", Name.toString());
		recyclerView.setAdapter(recycleAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.productlist, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
