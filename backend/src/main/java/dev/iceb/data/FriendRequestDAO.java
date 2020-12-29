package dev.iceb.data;

import java.util.Set;

import dev.iceb.beans.FriendRequest;

public interface FriendRequestDAO extends GenericDAO<FriendRequest> {

	Set<FriendRequest> getSentRequests(Integer id);

	Set<FriendRequest> getReceivedRequests(Integer id);
	
	
}
