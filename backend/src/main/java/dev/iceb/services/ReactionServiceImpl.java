package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Reaction;
import dev.iceb.data.ReactionDAO;
import dev.iceb.data.ReactionDAOFactory;

public class ReactionServiceImpl implements ReactionService {

	private ReactionDAO ReactionDao;
	
	public ReactionServiceImpl() {
		ReactionDAOFactory rdf = new ReactionDAOFactory();
		ReactionDao = rdf.getReactionDAO();
	}
	@Override
	public Reaction addReaction(Reaction p) {
		return ReactionDao.add(p);
	}

	@Override
	public Reaction getReactionById(Integer id) {
		return ReactionDao.getById(id);
	}

	@Override
	public Set<Reaction> getReactions() {
		return ReactionDao.getAll();
	}

	@Override
	public void updateReaction(Reaction p) {
		ReactionDao.update(p);
	}

	@Override
	public void removeReaction(Reaction p) {
		ReactionDao.delete(p);
	}


}
