package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Message;

public interface MessageService {
	// "create" method: returns the unique identifier of the added Cat
	public Message addMessage(Message p);
	// "read" methods
	public Message getMessageById(Integer id);
	public Set<Message> getMessages();
	// "update" methods
	public void updateMessage(Message p);
	// "delete" methods
	public void removeMessage(Message p);
}
