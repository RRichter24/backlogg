package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Message;
import dev.iceb.data.MessageDAO;
import dev.iceb.data.MessageDAOFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
	private MessageDAO MessageDao;
	
	@Autowired
	public MessageServiceImpl(MessageDAO mDAO) {
		MessageDao = mDAO;
	}
	@Override
	public Message addMessage(Message p) {
		return MessageDao.add(p);
	}

	@Override
	public Message getMessageById(Integer id) {
		return MessageDao.getById(id);
	}

	@Override
	public Set<Message> getMessages() {
		return MessageDao.getAll();
	}

	@Override
	public void updateMessage(Message p) {
		MessageDao.update(p);
	}

	@Override
	public void removeMessage(Message p) {
		MessageDao.delete(p);
	}

}
