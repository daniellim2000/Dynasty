package com.example.danie.teamdynasty;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 12/8/2016.
 */
public class Post implements Parcelable {
	private String author;
	private String content;
	private List<Comment> comments;

	public Post(String author, String content, List<Comment> comments) {
		this.author = author;
		this.content = content;
		this.comments = comments;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public List<Comment> getComments() {
		return comments;
	}

	protected Post(Parcel in) {
		author = in.readString();
		content = in.readString();
		if (in.readByte() == 0x01) {
			comments = new ArrayList<Comment>();
			in.readList(comments, Comment.class.getClassLoader());
		} else {
			comments = null;
		}
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(author);
		dest.writeString(content);
		if (comments == null) {
			dest.writeByte((byte) (0x00));
		} else {
			dest.writeByte((byte) (0x01));
			dest.writeList(comments);
		}
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
		@Override
		public Post createFromParcel(Parcel in) {
			return new Post(in);
		}

		@Override
		public Post[] newArray(int size) {
			return new Post[size];
		}
	};
}