package com.JSON.ows;

import java.util.ArrayList;
import java.util.List;



public class Datastore {
	private static Datastore instance = new Datastore();
	public List<String> Name_Ethnic_wear;
	public List<String> Price_Ethnic_Wear;
	public List<String> Special_price_Ethnic_wear;
	public List<String> Image_Address_Ethnic_wear;

	public static Datastore getInstance() {
        return instance;
    }
	
	public  void set_Name_ethnicwear(List<String> name_ethnicwear) {
		// TODO Auto-generated method stub
	Name_Ethnic_wear=new ArrayList<String>(name_ethnicwear);
		
	}

	public void set_Price_ethnicwear(List<String> price_ethnicwear) {
		// TODO Auto-generated method stub
		Price_Ethnic_Wear=new ArrayList<String>(price_ethnicwear);
	}

	public  void set_SpecialPrice_ethnic_wear(List<String> specialprice_ethnicwear) {
		// TODO Auto-generated method stub
		Special_price_Ethnic_wear=new ArrayList<String>(specialprice_ethnicwear);
	}
	public  void set_Imageaddress_ethnicwear(List<String> image_ethnicwear) {
		// TODO Auto-generated method stub
		Image_Address_Ethnic_wear=new ArrayList<String>(image_ethnicwear);
	}
	public List<String> get_Name_EthnicWear() {
		// TODO Auto-generated method stub
		return Name_Ethnic_wear;
	}
	public List<String> get_Image_ethnicwear() {
		// TODO Auto-generated method stub
		return Image_Address_Ethnic_wear;
	}
	public List<String> get_Price_ethnicwear() {
		// TODO Auto-generated method stub
		return Price_Ethnic_Wear;
	}
	public List<String> get_sPrice_ethnicwear() {
		// TODO Auto-generated method stub
		return Special_price_Ethnic_wear;
	}
	

}
