package dev.iceb.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.iceb.beans.FriendRequest;
import dev.iceb.beans.Person;
import dev.iceb.data.FriendRequestDAO;
import dev.iceb.data.PersonDAO;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {
	
	private FriendRequestDAO frDao;
	private PersonDAO pDao;
	
	@Autowired
	public FriendRequestServiceImpl(FriendRequestDAO fr, PersonDAO p) {
		frDao = fr;
		pDao = p;
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
	
	public Set<Person> getFriendsList(Integer id){
		Set<FriendRequest> fullList = frDao.getUserFriendsList(id);
		Set<Person> friends = new HashSet<Person>();
		for(FriendRequest req: fullList) {
			if(req.getPerson1_id() != id) {
				friends.add(pDao.getById(req.getPerson1_id()));
			}else {
				friends.add(pDao.getById(req.getPerson2_id()));
			}
		}
		return friends;
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
