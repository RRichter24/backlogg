package dev.iceb.data;

public class ReactionDAOFactory {
	public ReactionDAO getReactionDAO() {
		return new ReactionHibernate();
	}
}
