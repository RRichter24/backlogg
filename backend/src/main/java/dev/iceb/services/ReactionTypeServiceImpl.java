package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.ReactionType;
import dev.iceb.data.ReactionTypeDAO;
import dev.iceb.data.ReactionTypeDAOFactory;

public class ReactionTypeServiceImpl implements ReactionTypeService {
	private ReactionTypeDAO ReactionTypeDao;
	
	public ReactionTypeServiceImpl() {
		ReactionTypeDAOFactory rdf = new ReactionTypeDAOFactory();
		ReactionTypeDao = rdf.getReactionTypeDAO();
	}
	@Override
	public ReactionType addReactionType(ReactionType p) {
		return ReactionTypeDao.add(p);
	}

	@Override
	public ReactionType getReactionTypeById(Integer id) {
		return ReactionTypeDao.getById(id);
	}

	@Override
	public Set<ReactionType> getReactionTypes() {
		return ReactionTypeDao.getAll();
	}

	@Override
	public void updateReactionType(ReactionType p) {
		ReactionTypeDao.update(p);
	}

	@Override
	public void removeReactionType(ReactionType p) {
		ReactionTypeDao.delete(p);
	}


}
