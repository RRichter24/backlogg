package dev.iceb.data;

public class PostDAOFactory {
    
    public PostDAO getPostDAO() {
        
        return new PostHibernate();
    }
}
