package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.ReactionType;

public interface ReactionTypeService {
	// "create" method: returns the unique identifier of the added Cat
	public ReactionType addReactionType(ReactionType p);
	// "read" methods
	public ReactionType getReactionTypeById(Integer id);
	public Set<ReactionType> getReactionTypes();
	// "update" methods
	public void updateReactionType(ReactionType p);
	// "delete" methods
	public void removeReactionType(ReactionType p);
}
