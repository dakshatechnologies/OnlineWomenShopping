package com.example.neww;

import java.util.ArrayList;


import com.JSON.ows.Webservices;

import com.viewpagerindicator.CirclePageIndicator;



import android.R.color;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class HomeFragment extends Fragment implements OnChildClickListener {
	
	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();
	
	final String url1="http://onlinewomenshopping.com/EthnicWear.php?id=19";
	 final String url2="http://onlinewomenshopping.com/EthnicWear.php?id=4";
	
	int[] images;
	ViewPager viewPager;
	ViewpagaerAdapter viewadapter;
	
	CirclePageIndicator mIndicator;
	Button button;
	public HomeFragment(){}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		View v=inflater.inflate(R.layout.fragment_home,container, false);
		
		images=new int[]{R.drawable.banner,R.drawable.sandle,R.drawable.bags,R.drawable.jewellery};
		
		viewPager = (ViewPager)v.findViewById(R.id.pager);
		button=(Button)v.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		//		
				new Webservices().mEthnicwear(getActivity(), url1);
				Intent io=new Intent(getActivity(),Productlist.class);
				getActivity().startActivity(io);
			}
		});
		viewadapter = new ViewpagaerAdapter(getActivity(),images);
		
		viewPager.setAdapter(viewadapter);
		mIndicator = (CirclePageIndicator)v.findViewById(R.id.indicator);
		mIndicator.setBackgroundColor(Color.DKGRAY);
	    mIndicator.setViewPager(viewPager);
	      
		
		 ExpandableListView expandableList = (ExpandableListView)v.findViewById(R.id.expandableListView); // you can use (ExpandableListView) findViewById(R.id.list)

	    	expandableList.setDividerHeight(2);
	    	expandableList.setGroupIndicator(null);
	    	expandableList.setClickable(true);

	    	setGroupParents();
	    	setChildData();

	    	ExpandablelistAdapter adapter = new ExpandablelistAdapter(parentItems, childItems);
	    	adapter.setInflater((LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE), getActivity());
	    	expandableList.setAdapter(adapter);
	    	expandableList.setOnChildClickListener(this);
		
		
		return v;
		
		
	}
	
	public void setGroupParents() {
		parentItems.add("Colthing");
		parentItems.add("Accessories");
		parentItems.add("Footwear");
		parentItems.add("Jewellery");
		parentItems.add("Home & kitchen");
		parentItems.add("Appliances");
	}
	
	public void setChildData() {

		// Android
		ArrayList<String> child = new ArrayList<String>();
		child.add("Ethnic Wear");
		child.add("Western Wear");
		child.add("Winter Wear");
		child.add("Bollywood collection");
		childItems.add(child);

		// Core Java
		child = new ArrayList<String>();
		child.add("Bags");
		child.add("Purses");
		child.add("scarves & stoles");
		child.add("watches");
		child.add("Brooches");
		childItems.add(child);

		// Desktop Java
		child = new ArrayList<String>();
		child.add("Flats");
		child.add("Sandals");
		child.add("Bellies");
		child.add("heels");
		child.add("Slippers");
		childItems.add(child);

		// Enterprise Java
		child = new ArrayList<String>();
		child.add("Necklaces");
		child.add("Pendants");
		child.add("earrings");
		child.add("Bangle");
		childItems.add(child);
		
		child = new ArrayList<String>();
		child.add("Home Essentials");
		child.add("Home Decor");
		childItems.add(child);
		
		child = new ArrayList<String>();
		child.add("Home Appliances");
		child.add("Kitchen Appliances");
		child.add("combos");
		childItems.add(child);
		
	}
	
	 @Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
		 
//		 Toast.makeText(
//                getActivity(),
//                parentItems.get(groupPosition)
//                        + " : "
//                        + childItems.get(parentItems.get(groupPosition)).get(
//                                 childPosition)+ childPosition, Toast.LENGTH_SHORT) .show();
		 
		
		
		 
		
		 display(childPosition, groupPosition);
			return false;
		}
	 
	 
	 
		private void display(int childPosition, int groupPosition) {
			
		//	  Fragment fragment = null;
			  
if(groupPosition==0 && childPosition==0)
{
	new Webservices().mEthnicwear(getActivity(), url1);
//	Intent io=new Intent(getActivity(),Productlist.class);
//	getActivity().startActivity(io);
	}

else if(groupPosition==0 && childPosition==1)
{
	new Webservices().mEthnicwear(getActivity(),url2);
	Intent io=new Intent(getActivity(),Productlist.class);
	getActivity().startActivity(io);
}
}
				

			
//		        if (fragment != null) {
//		            FragmentManager fragmentManager = getFragmentManager();
//		            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
//		 
//		            // update selected item and title, then close the drawer
//		           
//		        } else {
//		            // error in creating fragment
//		            Log.e("MainActivity", "Error in creating fragment");
//		        }
//			
//			}
	
	
   
}
