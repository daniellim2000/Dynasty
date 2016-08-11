package com.example.danie.teamdynasty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	/*TODO: put a bunch of stuff here to keep track of ur current used choices etc

	 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

	//dummmy method cos lazy to findviewbyid, remove this to use the open chat method legitly
	public void openChat(View view){
		ArrayList<Message> messages = new ArrayList<>();
		messages.add(new Message("Wow you dumbass", true));
		messages.add(new Message("Why you say this to me", false));
		messages.add(new Message("I cry", false));
		messages.add(new Message("When I have to rush Splash Awards", false));
		messages.add(new Message("and dont do homework", false));
		messages.add(new Message("do you feel me wee soong", false));
		messages.add(new Message("gun la qiong bi", true));
		messages.add(new Message(":(", false));

		openChat(messages, "Daniel Lim Wee Soong");
	}

	//also lazy method for the button, pls remove this afterwards
	public void viewChoices(View view) {
		viewChoices(new ArrayList<Object>());
	}

	//yet another dummy method, delete plox
	public void openPost(View view) {
		List<Comment> comments = new ArrayList<>();
		comments.add(new Comment("Daniel Lim Wee Soong", "kill yourself"));
		comments.add(new Comment("Lim Shi Hern", "Daniel stop being so bad to piggy"));
		comments.add(new Comment("Jeff Sieu", "Seriously Shi Hern, we have to do Splash Awards now. It's not a time to joke around"));
		comments.add(new Comment("Daniel Lim Wee Soong", "eh dynasty la, if we cannot finish then we wont get the $20000 lo"));
		comments.add(new Comment("Jeff Sieu", "^"));
		comments.add(new Comment("Lim Shi Hern", "Ok then piggy can do splash awards with me! Yay pigggy!!"));
		comments.add(new Comment("Jeff Sieu", "..."));
		comments.add(new Comment("Daniel Lim Wee Soong", "...."));
		Post post = new Post("Lim Shi Hern", "Piggy oink!", comments);
		openPost(post);
	}

	/**
	 * Starts a choice activity to view the current choices that the user has.
	 * @param choices The list of choices the user has to choose from
	 */
	public void viewChoices(ArrayList<Object> choices) {
		Intent intent = new Intent(this, ChoiceActivity.class);
		/* TODO: Make whatever object you are working with, implement Parcelable, then the bottom method should work
			Very easy, just go to http://www.parcelabler.com/ and copy the whole class over, and then paste it back into the editor
		 */
		//intent.putParcelableArrayListExtra("choices", choices);
		/* TODO: Then you retrieve the parcelable list in the ChoiceActivity, from the intent. Example is in ChatActivity

		 */
		startActivity(intent);
	}

	/**
	 * Starts a chat activity with preloaded messages and a recipient.
	 * @param messages The list of messages to initialise the activity with
	 * @param senderName The name of the other person in the conversation
	 */
    public void openChat(ArrayList<Message> messages, String senderName) {
        Intent intent = new Intent(this, ChatActivity.class);
		intent.putParcelableArrayListExtra("messageList", messages);
		intent.putExtra("senderName", senderName);
		startActivity(intent);
    }

	public void openPost(Post post) {
		Intent intent = new Intent(this, PostActivity.class);
		intent.putExtra("post", post);
		startActivity(intent);
	}
}
