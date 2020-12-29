package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.RequestStatus;

public interface RequestStatusService {
	public RequestStatus addRequestStatus(RequestStatus f);
	
	public RequestStatus getRequestStatusById(Integer id);
	public Set<RequestStatus> getAllRequestStati();
	
	public void updateRequestStatus(RequestStatus f);
	
	public void deleteRequestStatus(RequestStatus f);
}