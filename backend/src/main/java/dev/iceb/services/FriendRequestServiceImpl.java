package dev.iceb.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.iceb.beans.FriendRequest;
import dev.iceb.data.FriendRequestDAO;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {
	
	private FriendRequestDAO frDao;
	
	@Autowired
	public FriendRequestServiceImpl(FriendRequestDAO fr) {
		frDao = fr;
	}
	
	
	@Override
	public FriendRequest addFriendRequest(FriendRequest f) {
		return frDao.add(f);
	}

	@Override
	public FriendRequest getFriendRequestById(Integer id) {
		return frDao.getById(id);
	}

	@Override
	public Set<FriendRequest> getAllFriendRequests() {
		return frDao.getAll();
	}

	@Override
	public Set<FriendRequest> getSentFriendRequests(Integer id) {
		return frDao.getSentRequests(id);
	}

	@Override
	public Set<FriendRequest> getReceivedFriendRequests(Integer id) {
		return frDao.getReceivedRequests(id);
	}

	@Override
	public void updateFriendRequest(FriendRequest f) {
		frDao.update(f);
	}

	@Override
	public void deleteFriendRequest(FriendRequest f) {
		frDao.delete(f);
	}

}
