package com.example.danie.teamdynasty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jeff on 11/8/2016.
 */
public class Message implements Parcelable {
	String message;
	boolean received;

	public Message(String message, boolean received) {
		this.message = message;
		this.received = received;
	}

	public String getMessage() {
		return message;
	}

	public boolean isReceived() {
		return received;
	}

	protected Message(Parcel in) {
		message = in.readString();
		received = in.readByte() != 0x00;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(message);
		dest.writeByte((byte) (received ? 0x01 : 0x00));
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
		@Override
		public Message createFromParcel(Parcel in) {
			return new Message(in);
		}

		@Override
		public Message[] newArray(int size) {
			return new Message[size];
		}
	};
}