package com.example.neww;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ViewpagaerAdapter extends PagerAdapter {
	LayoutInflater Linflater;
	int images[];
	Activity context;

	public ViewpagaerAdapter(Activity activity, int[] image) {
		// TODO Auto-generated constructor stub
		images=image;
		context= activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return images.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == ((RelativeLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		Linflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rview= Linflater.inflate(R.layout.viewpager_item,container,false);
		
		ImageView imageView=(ImageView)rview.findViewById(R.id.thumbnail);
		imageView.setImageResource(images[position]);
		((ViewPager)container).addView(rview);
		return rview;
		
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager)container).removeView((RelativeLayout)object);
	}
}
