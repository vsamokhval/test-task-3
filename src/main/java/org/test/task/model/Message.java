package org.test.task.model;

public class Message {

	private long id;
	
	private User recipient;
	
	private String content;
	
	public Message(){
		this.id = 0;
		this.recipient = new User();
	}
	
	public Message(long id, User recipient, String content){
		this.id = id;
		this.recipient = recipient;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Message))
			return false;
		Message other = (Message) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", recipient=" + recipient + ", content=" + content + "]";
	}
	

	
}
