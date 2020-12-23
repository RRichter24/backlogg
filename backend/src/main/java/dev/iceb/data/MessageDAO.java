package dev.iceb.data;

import java.util.Set;

import dev.iceb.beans.Message;

public interface MessageDAO extends GenericDAO<Message>{
	public Set<Message> MessagesByUserId(Integer id);
}
