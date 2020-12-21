package dev.iceb.data;

public class ReactionTypeDAOFactory {
	public ReactionTypeDAO getReactionTypeDAO() {
		return new ReactionTypeHibernate();
	}
}
