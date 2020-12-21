package dev.iceb.data;

public class CommentDAOFactory {
    
    public CommentDAO getCommentDAO() {
        
        return new CommentHibernate();
    }
}
