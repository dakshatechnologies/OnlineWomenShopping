package com.example.neww;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class HomeFragment extends Fragment{

	private ArrayList<String> parentItems = new ArrayList<String>();
	HashMap<String, List<String>> listDataChild;

	String IDS[] = new String[] { "19", "4", "6", "346", "36", "37", "39",
			"362", "365", "52", "53", "54", "59", "358", "77", "75", "76",
			"78", "317", "316", "195", "194", "369" };

	final String url1 = "http://onlinewomenshopping.com/EthnicWear.php?id=19";
	final String url2 = "http://onlinewomenshopping.com/EthnicWear.php?id=4";

	int[] images;
	ViewPager viewPager;
	ViewpagaerAdapter viewadapter;

	CirclePageIndicator mIndicator;
	Button button;

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// return super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_home, container, false);

		images = new int[] { R.drawable.banner, R.drawable.sandle,
				R.drawable.bags, R.drawable.jewellery };

		viewPager = (ViewPager) v.findViewById(R.id.pager);
		button = (Button) v.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//
				// new Webservices().mEthnicwear(getActivity(), url1);
				// Intent io=new Intent(getActivity(),Productlist.class);
				// getActivity().startActivity(io);
			}
		});
		viewadapter = new ViewpagaerAdapter(getActivity(), images);

		viewPager.setAdapter(viewadapter);
		mIndicator = (CirclePageIndicator) v.findViewById(R.id.indicator);
		mIndicator.setBackgroundColor(Color.DKGRAY);
		mIndicator.setViewPager(viewPager);
		setGroupParents();
		setChildData();

		ExpandableListView expandableList = (ExpandableListView) v.findViewById(R.id.expandableListView); 
		 ExpandableListAdap listAdapter=new ExpandableListAdap(getActivity(),parentItems,listDataChild);
		expandableList.setAdapter(listAdapter);
		expandableList.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				display(childPosition, groupPosition);
				return true;
			}
		});

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
		listDataChild = new HashMap<String, List<String>>();
		// Android
		ArrayList<String> child1 = new ArrayList<String>();
		child1.add("Ethnic Wear");
		child1.add("Western Wear");
		child1.add("Winter Wear");
		child1.add("Bollywood collection");

		// Core Java
		ArrayList<String> child2 = new ArrayList<String>();
		child2.add("Bags");
		child2.add("Purses");
		child2.add("scarves & stoles");
		child2.add("watches");
		child2.add("Brooches");

		// Desktop Java
		ArrayList<String> child3 = new ArrayList<String>();
		child3.add("Flats");
		child3.add("Sandals");
		child3.add("Bellies");
		child3.add("heels");
		child3.add("Slippers");

		// Enterprise Java
		ArrayList<String> child4 = new ArrayList<String>();
		child4.add("Necklaces");
		child4.add("Pendants");
		child4.add("earrings");
		child4.add("Bangle");

		ArrayList<String> child5 = new ArrayList<String>();
		child5.add("Home Essentials");
		child5.add("Home Decor");

		ArrayList<String> child6 = new ArrayList<String>();
		child6.add("Home Appliances");
		child6.add("Kitchen Appliances");
		child6.add("combos");
		listDataChild.put(parentItems.get(0), child1);
		listDataChild.put(parentItems.get(1), child2);
		listDataChild.put(parentItems.get(2), child3);
		listDataChild.put(parentItems.get(3), child4);
		listDataChild.put(parentItems.get(4), child5);
		listDataChild.put(parentItems.get(5), child6);

	}

	

	public void display(int childPosition, int groupPosition) {

		// Fragment fragment = null;

		if (groupPosition == 0) {

			switch (childPosition) {
			case 0:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[0]);
				break;
			case 1:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[1]);
				break;
			case 2:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[2]);
				break;
			case 3:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[3]);
				break;
			}
		}

		else if (groupPosition == 1) {
			switch (childPosition) {
			case 0:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[4]);
				break;
			case 1:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[5]);
				break;
			case 2:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[6]);
				break;
			case 3:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[7]);
				break;
			case 4:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[8]);
				break;
			}

		} else if (groupPosition == 2) {
			switch (childPosition) {
			case 0:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[9]);
				break;
			case 1:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[10]);
				break;
			case 2:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[11]);
				break;
			case 3:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[12]);
				break;
			case 4:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[13]);
				break;
			}

		} else if (groupPosition == 3) {
			switch (childPosition) {
			case 0:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[14]);
				break;
			case 1:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[15]);
				break;
			case 2:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[16]);
				break;
			case 3:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[17]);
				break;

			}

		} else if (groupPosition == 4) {
			switch (childPosition) {
			case 0:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[18]);
				break;
			case 1:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[19]);
				break;

			}

		} else if (groupPosition == 5) {
			switch (childPosition) {
			case 0:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[20]);
				break;
			case 1:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[21]);
				break;
			case 2:
				new Webservices().mEthnicwear(getActivity(),
						"http://onlinewomenshopping.com/EthnicWear.php?id="
								+ IDS[22]);
				break;

			}

		}
	}

	// if (fragment != null) {
	// FragmentManager fragmentManager = getFragmentManager();
	// fragmentManager.beginTransaction().replace(R.id.content_frame,
	// fragment).addToBackStack(null).commit();
	//
	// // update selected item and title, then close the drawer
	//
	// } else {
	// // error in creating fragment
	// Log.e("MainActivity", "Error in creating fragment");
	// }
	//
	// }

}
