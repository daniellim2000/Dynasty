package com.example.danie.teamdynasty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Jeff on 12/8/2016.
 */
public class PostActivity extends AppCompatActivity {
	private Post post;

	private NestedScrollView mRootView;

	private TextView mAuthor;
	private TextView mPostContent;
	private TextView mPostCommentCount;

	private RecyclerView mCommentsView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);

		getSupportActionBar().setTitle("Post");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		post = getIntent().getParcelableExtra("post");

		mRootView = (NestedScrollView) findViewById(R.id.post_root);

		mAuthor = (TextView) findViewById(R.id.post_poster);
		mPostContent = (TextView) findViewById(R.id.post_content);
		mPostCommentCount = (TextView) findViewById(R.id.post_comment_count);

		mAuthor.setText(post.getAuthor());
		mPostContent.setText(post.getContent());


		mCommentsView = (RecyclerView) findViewById(R.id.post_comments);
		mCommentsView.setNestedScrollingEnabled(false);
		mCommentsView.setLayoutManager(new LinearLayoutManager(this));
		mCommentsView.setAdapter(new CommentsAdapter(this, post.getComments()));

		mPostCommentCount.setText(post.getComments().size()+" comments");

		mRootView.scrollTo(0, 0);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == android.R.id.home) {
			onBackPressed();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
