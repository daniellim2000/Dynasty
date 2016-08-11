package com.example.danie.teamdynasty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 12/8/2016.
 */
public class ChoiceActivity extends AppCompatActivity {
	private RecyclerView mChoiceView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Make a choice");

		List<Object> choices = new ArrayList<>();
		choices.add("Dummy item 1");
		choices.add("Dummy item 2");
		choices.add("Dummy item 3");
		/* TODO: Try to retrieve the list of choices from the intent */

		mChoiceView = (RecyclerView) findViewById(R.id.choice_list);
		mChoiceView.setAdapter(new ChoiceAdapter(this, choices));
		mChoiceView.setLayoutManager(new LinearLayoutManager(this));
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
