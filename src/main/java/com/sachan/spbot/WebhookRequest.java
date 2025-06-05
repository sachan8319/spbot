package com.sachan.spbot;

public class WebhookRequest {


		  private String typeWebhook;
		    private Long timestamp;
		    private String idMessage;
		    private SenderData senderData;
		    private MessageData messageData;
		    
		    public String getTypeWebhook() {
		        return typeWebhook;
		    }

		    public void setTypeWebhook(String typeWebhook) {
		        this.typeWebhook = typeWebhook;
		    }

		    public Long getTimestamp() {
		        return timestamp;
		    }

		    public void setTimestamp(Long timestamp) {
		        this.timestamp = timestamp;
		    }

		    public String getIdMessage() {
		        return idMessage;
		    }

		    public void setIdMessage(String idMessage) {
		        this.idMessage = idMessage;
		    }

		    public SenderData getSenderData() {
		        return senderData;
		    }

		    public void setSenderData(SenderData senderData) {
		        this.senderData = senderData;
		    }

		    public MessageData getMessageData() {
		        return messageData;
		    }

		    public void setMessageData(MessageData messageData) {
		        this.messageData = messageData;
		    }


	

}
