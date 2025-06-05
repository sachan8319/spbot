package com.sachan.spbot;

public class MessageData {

	 public String getTypeMessage() {
		return typeMessage;
	}
	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}
	public TextMessageData getTextMessageData() {
		return textMessageData;
	}
	public void setTextMessageData(TextMessageData textMessageData) {
		this.textMessageData = textMessageData;
	}
	private String typeMessage;
	    private TextMessageData textMessageData;

}
