package dev.iceb.data;

public class MessageDAOFactory {
    
	public MessageDAO getMessageDAO() {
        
        return new MessageHibernate();
    }
}
