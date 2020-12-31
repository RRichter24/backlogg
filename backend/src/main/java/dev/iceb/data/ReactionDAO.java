package dev.iceb.data;

import java.util.Set;

import dev.iceb.beans.Reaction;

public interface ReactionDAO extends GenericDAO<Reaction> {

	Set<Reaction> getByPostId(Integer pid);

}
