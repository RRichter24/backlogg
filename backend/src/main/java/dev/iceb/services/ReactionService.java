package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Reaction;

public interface ReactionService {
	// "create" method: returns the unique identifier of the added Cat
	public Reaction addReaction(Reaction p);
	// "read" methods
	public Reaction getReactionById(Integer id);
	public Set<Reaction> getReactions();
	// "update" methods
	public void updateReaction(Reaction p);
	// "delete" methods
	public void removeReaction(Reaction p);
}
