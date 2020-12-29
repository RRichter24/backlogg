package dev.iceb.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class FriendRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer person1_id;
	private Integer person2_id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "request_status_id")
	private RequestStatus request_status;
	
	public FriendRequest() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPerson1_id() {
		return person1_id;
	}

	public void setPerson1_id(Integer person1_id) {
		this.person1_id = person1_id;
	}

	public Integer getPerson2_id() {
		return person2_id;
	}

	public void setPerson2_id(Integer person2_id) {
		this.person2_id = person2_id;
	}

	public RequestStatus getRequest_status() {
		return request_status;
	}

	public void setRequest_status(RequestStatus request_status) {
		this.request_status = request_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((person1_id == null) ? 0 : person1_id.hashCode());
		result = prime * result + ((person2_id == null) ? 0 : person2_id.hashCode());
		result = prime * result + ((request_status == null) ? 0 : request_status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendRequest other = (FriendRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (person1_id == null) {
			if (other.person1_id != null)
				return false;
		} else if (!person1_id.equals(other.person1_id))
			return false;
		if (person2_id == null) {
			if (other.person2_id != null)
				return false;
		} else if (!person2_id.equals(other.person2_id))
			return false;
		if (request_status == null) {
			if (other.request_status != null)
				return false;
		} else if (!request_status.equals(other.request_status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FriendRequest [id=" + id + ", person1_id=" + person1_id + ", person2_id=" + person2_id
				+ ", request_status=" + request_status + "]";
	}
	
	
	
	
}
