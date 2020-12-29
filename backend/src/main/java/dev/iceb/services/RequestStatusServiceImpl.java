package dev.iceb.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.iceb.beans.RequestStatus;
import dev.iceb.data.RequestStatusDAO;


@Service
public class RequestStatusServiceImpl implements RequestStatusService {
	
	private RequestStatusDAO rsDao;
	
	@Autowired
	public RequestStatusServiceImpl(RequestStatusDAO rs) {
		rsDao = rs;
	}
	
	
	@Override
	public RequestStatus addRequestStatus(RequestStatus f) {
		return rsDao.add(f);
	}

	@Override
	public RequestStatus getRequestStatusById(Integer id) {
		return rsDao.getById(id);
	}

	@Override
	public Set<RequestStatus> getAllRequestStati() {
		return rsDao.getAll();
	}

	@Override
	public void updateRequestStatus(RequestStatus f) {
		rsDao.update(f);
	}

	@Override
	public void deleteRequestStatus(RequestStatus f) {
		rsDao.delete(f);
	}
}
