package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Reaction;
import dev.iceb.data.ReactionDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionServiceImpl implements ReactionService {

	private ReactionDAO reactionDAO;
	
	@Autowired
	public ReactionServiceImpl(ReactionDAO rDAO) {
		reactionDAO = rDAO;
	}
	@Override
	public Reaction addReaction(Reaction p) {
		return reactionDAO.add(p);
	}

	@Override
	public Reaction getReactionById(Integer id) {
		return reactionDAO.getById(id);
	}

	@Override
	public Set<Reaction> getReactions() {
		return reactionDAO.getAll();
	}

	@Override
	public void updateReaction(Reaction p) {
		reactionDAO.update(p);
	}

	@Override
	public void removeReaction(Reaction p) {
		reactionDAO.delete(p);
	}


}
