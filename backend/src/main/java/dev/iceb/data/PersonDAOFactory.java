package dev.iceb.data;

public class PersonDAOFactory {
    
    public PersonDAO getPersonDAO() {
        
        return new PersonHibernate();
    }

}