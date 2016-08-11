package com.example.danie.teamdynasty;

/**
 * Created by Jeff on 12/8/2016.
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

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
	private Context context;
	private RecyclerView mRecyclerView;
	private List<Comment> comments;

	public CommentsAdapter(Context context, List<Comment> comments) {
		this.context = context;
		this.comments = comments;
	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
		mRecyclerView = recyclerView;
	}

	@Override
	public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_comment, parent, false);
		return new CommentsAdapter.CommentViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final CommentViewHolder holder, final int position) {
		holder.mAuthorView.setText(comments.get(position).getAuthor());
		holder.mContentView.setText(comments.get(position).getText());
		holder.mRootView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}

	@Override
	public int getItemCount() {
		return comments.size();
	}

	public class CommentViewHolder extends RecyclerView.ViewHolder {
		protected View mRootView;
		protected TextView mAuthorView;
		protected TextView mContentView;

		public CommentViewHolder(View v) {
			super(v);
			mRootView = v.findViewById(R.id.comment_root);
			mAuthorView = (TextView) v.findViewById(R.id.comment_poster);
			mContentView = (TextView) v.findViewById(R.id.comment_content);
		}
	}
}
