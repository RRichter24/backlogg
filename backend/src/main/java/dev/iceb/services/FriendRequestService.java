package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.FriendRequest;
import dev.iceb.beans.Person;

public interface FriendRequestService {
	public FriendRequest addFriendRequest(FriendRequest f);
	
	public FriendRequest getFriendRequestById(Integer id);
	public Set<FriendRequest> getAllFriendRequests();
	public Set<FriendRequest> getSentFriendRequests(Integer id);
	public Set<FriendRequest> getReceivedFriendRequests(Integer id);
	public Set<Person> getFriendsList(Integer id);
	public void updateFriendRequest(FriendRequest f);
	
	public void deleteFriendRequest(FriendRequest f);

}
