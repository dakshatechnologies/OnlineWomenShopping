package com.example.neww;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.JSON.ows.Webservices;

public class RecycleAdapter extends
		RecyclerView.Adapter<RecycleAdapter.ViewHolder> implements
		View.OnClickListener, View.OnLongClickListener {

	private ArrayList<String> mDataset;
	private static Context sContext;
	public ImageLoader imageLoader;

	ArrayList<String> Name;
	ArrayList<String> Image;
	ArrayList<String> price;

	// Adapter's Constructor
	public RecycleAdapter(Context context, ArrayList<String> myDataset,
			ArrayList<String> name2, ArrayList<String> price2) {

		Name = new ArrayList<String>(name2);
		Image = new ArrayList<String>(myDataset);
		price = new ArrayList<String>(price2);
		//
		sContext = context;
		imageLoader = new ImageLoader(sContext);
	}

	/*
	 * public RecycleAdapter(Context applicationContext, ArrayList<String>
	 * myDataset) { // TODO Auto-generated constructor stub mDataset =
	 * myDataset; sContext = applicationContext; }
	 */

	// Create new views. This is invoked by the layout manager.
	@Override
	public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		// Create a new view by inflating the row item xml.
		View v = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.product_items, parent, false);

		// Set the view to the ViewHolder
		ViewHolder holder = new ViewHolder(v);
		// holder.price.setOnClickListener(RecycleAdapter.this);
		// holder.price.setOnLongClickListener(RecycleAdapter.this);
		//
		// holder.price.setTag(holder);

		return holder;
	}

	// Replace the contents of a view. This is invoked by the layout manager.
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		holder.nametxt.setText(String.valueOf(position) + ". ");
		// Get element from your dataset at this position and set the text for
		// the specified element
		holder.pricetxt.setText("Rs. "+price.get(position));
		holder.nametxt.setText(Name.get(position));
		imageLoader.displayImage(Image.get(position), holder.itemsimage);

		// Set the color to red if row is even, or to green if row is odd.
		// if (position % 2 == 0) {
		// holder.mNumberRowTextView.setTextColor(Color.RED);
		// } else {
		// holder.mNumberRowTextView.setTextColor(Color.GREEN);
		// }
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return Name.size();
	}

	// Implement OnClick listener. The clicked item text is displayed in a Toast
	// message.
	@Override
	public void onClick(View view) {
		ViewHolder holder = (ViewHolder) view.getTag();
		if (view.getId() == holder.pricetxt.getId()) {
			Toast.makeText(sContext, holder.pricetxt.getText(),
					Toast.LENGTH_SHORT).show();

		}
	}

	// Implement OnLongClick listener. Long Clicked items is removed from list.
	@Override
	public boolean onLongClick(View view) {
		// ViewHolder holder = (ViewHolder) view.getTag();
		// if (view.getId() == holder.title.getId()) {
		// mDataset.remove(holder.getPosition());
		//
		// // Call this method to refresh the list and display the "updated"
		// list
		// notifyDataSetChanged();
		//
		// Toast.makeText(sContext, "Item " + holder.pricetxt.getText() +
		// " has been removed from list",
		// Toast.LENGTH_SHORT).show();
		// }
		return false;
	}

	// Create the ViewHolder class to keep references to your views
	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView nametxt;
		public TextView pricetxt;
		public ImageView itemsimage;

		/**
		 * Constructor
		 * 
		 * @param v
		 *            The container view which holds the elements from the row
		 *            item xml
		 */
		public ViewHolder(View v) {
			super(v);

			nametxt = (TextView) v.findViewById(R.id.productlisttext);
			pricetxt = (TextView) v.findViewById(R.id.tvpricelist);
			itemsimage = (ImageView) v.findViewById(R.id.productimagelist);
		}
	}

}