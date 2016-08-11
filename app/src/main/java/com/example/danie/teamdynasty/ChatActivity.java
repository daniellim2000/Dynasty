package com.example.danie.teamdynasty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 11/8/2016.
 */
public class ChatActivity extends AppCompatActivity {
	private RecyclerView chatView;
	private List<Message> messageList = new ArrayList<>();
	private EditText messageField;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		messageList = getIntent().getParcelableArrayListExtra("messageList");
		String senderName = getIntent().getStringExtra("senderName");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle(senderName);

		chatView = (RecyclerView) findViewById(R.id.message_list);
		chatView.setLayoutManager(new LinearLayoutManager(this));
		chatView.setAdapter(new ChatAdapter(this, messageList));

		messageField = (EditText) findViewById(R.id.message_field);

	}

	public void sendMessage() {
		//messageField.get
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
