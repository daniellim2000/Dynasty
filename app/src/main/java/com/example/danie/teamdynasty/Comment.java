package com.example.danie.teamdynasty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jeff on 12/8/2016.
 */
public class Comment implements Parcelable {
	protected String author;
	private String text;

	public Comment(String author, String text) {
		this.author = author;
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public String getText() {
		return text;
	}

	protected Comment(Parcel in) {
		author = in.readString();
		text = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(author);
		dest.writeString(text);
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator<Comment>() {
		@Override
		public Comment createFromParcel(Parcel in) {
			return new Comment(in);
		}

		@Override
		public Comment[] newArray(int size) {
			return new Comment[size];
		}
	};
}