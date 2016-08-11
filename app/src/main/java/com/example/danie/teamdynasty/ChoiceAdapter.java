package com.example.danie.teamdynasty;

/**
 * Created by Jeff on 11/8/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ChoiceViewHolder> {
	private Context context;
	private RecyclerView mRecyclerView;
	private List<Object> choices;

	public ChoiceAdapter(Context context, List<Object> choices) {
		this.context = context;
		this.choices = choices;
	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
		mRecyclerView = recyclerView;
	}

	@Override
	public ChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_choice, parent, false);
		return new ChoiceAdapter.ChoiceViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ChoiceViewHolder holder, final int position) {
		/*TODO: Resolve the comments directly below this todo*/
		//holder.mDescriptionView.setText("Insert choice text");
		// make an arraylist of R.drawable.ids or something, to display the icon for the choice
		//holder.mIconView.setDrawable(YOUR.ID.HERE);
		holder.mRootView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*TODO: Activate your choice here, when the choice is pressed*/
			}
		});
	}

	@Override
	public int getItemCount() {
		return choices.size();
	}

	public class ChoiceViewHolder extends RecyclerView.ViewHolder {
		protected View mRootView;
		protected ImageView mIconView;
		protected TextView mDescriptionView;

		public ChoiceViewHolder(View v) {
			super(v);
			mRootView = v.findViewById(R.id.choice_root);
			mIconView = (ImageView) v.findViewById(R.id.choice_icon);
			mDescriptionView = (TextView) v.findViewById(R.id.choice_description);
		}
	}
}
