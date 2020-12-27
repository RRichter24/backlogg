package dev.iceb.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String message_text;
	private Integer sender_id;
	private Integer receiver_id;
	private LocalDateTime message_date;
	
	public Message() {
		message_date = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage_text() {
		return message_text;
	}

	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}

	public Integer getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(Integer receiver_id) {
		this.receiver_id = receiver_id;
	}

	public LocalDateTime getMessage_date() {
		return message_date;
	}

	public void setMessage_date(LocalDateTime message_date) {
		this.message_date = message_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message_date == null) ? 0 : message_date.hashCode());
		result = prime * result + ((message_text == null) ? 0 : message_text.hashCode());
		result = prime * result + ((receiver_id == null) ? 0 : receiver_id.hashCode());
		result = prime * result + ((sender_id == null) ? 0 : sender_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message_date == null) {
			if (other.message_date != null)
				return false;
		} else if (!message_date.equals(other.message_date))
			return false;
		if (message_text == null) {
			if (other.message_text != null)
				return false;
		} else if (!message_text.equals(other.message_text))
			return false;
		if (receiver_id == null) {
			if (other.receiver_id != null)
				return false;
		} else if (!receiver_id.equals(other.receiver_id))
			return false;
		if (sender_id == null) {
			if (other.sender_id != null)
				return false;
		} else if (!sender_id.equals(other.sender_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message_text=" + message_text + ", sender_id=" + sender_id + ", receiver_id="
				+ receiver_id + ", message_date=" + message_date + "]";
	}
	
	
}
