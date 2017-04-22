package org.test.task.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="MESSAGES")
public class Message implements Comparable<Message>, Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "RECIPIENT_ID", nullable = false)
	private User recipient;

	@Column(name="CONTENT")
	private String content;
	
	public Message(){
		this.id = 0;
		this.recipient = new User();
	}
	
	public Message(Integer id, User recipient, String content){
		this.id = id;
		this.recipient = recipient;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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


	public int compareTo(Message msg) {
		return this.recipient.getName().compareTo(msg.recipient.getName());
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
