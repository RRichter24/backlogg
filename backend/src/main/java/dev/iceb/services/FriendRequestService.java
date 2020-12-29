package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.FriendRequest;

public interface FriendRequestService {
	public FriendRequest addFriendRequest(FriendRequest f);
	
	public FriendRequest getFriendRequestById(Integer id);
	public Set<FriendRequest> getAllFriendRequests();
	public Set<FriendRequest> getSentFriendRequests(Integer id);
	public Set<FriendRequest> getReceivedFriendRequests(Integer id);
	
	public void updateFriendRequest(FriendRequest f);
	
	public void deleteFriendRequest(FriendRequest f);
}
