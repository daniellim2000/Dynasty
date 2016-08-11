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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
	private Context context;
	private RecyclerView mRecyclerView;
	private List<Message> messages;

	public ChatAdapter(Context context, List<Message> messages) {
		this.context = context;
		this.messages = messages;
	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
		mRecyclerView = recyclerView;
	}

	@Override
	public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_message, parent, false);
		return new ChatViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ChatViewHolder holder, final int position) {
		holder.mMessageView.setText(messages.get(position).getMessage());

		if (!messages.get(position).isReceived()) {
			((LinearLayout) holder.mRootView).setGravity(Gravity.RIGHT);
		}
	}

	@Override
	public int getItemCount() {
		return messages.size();
	}

	public class ChatViewHolder extends RecyclerView.ViewHolder {
		protected View mRootView;
		protected TextView mMessageView;

		public ChatViewHolder(View v) {
			super(v);
			mRootView = v.findViewById(R.id.message_root);
			mMessageView = (TextView) v.findViewById(R.id.message_text);
		}
	}
}
