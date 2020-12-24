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
public class Reaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "reaction_type_id")
	private Integer reaction_type_id;
	private Integer person_id;
	private Integer post_id;
	
	public Reaction() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReaction_type() {
		return reaction_type_id;
	}

	public void setReaction_type(Integer reaction_type_id) {
		this.reaction_type_id = reaction_type_id;
	}

	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((person_id == null) ? 0 : person_id.hashCode());
		result = prime * result + ((post_id == null) ? 0 : post_id.hashCode());
		result = prime * result + ((reaction_type_id == null) ? 0 : reaction_type_id.hashCode());
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
		Reaction other = (Reaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (person_id == null) {
			if (other.person_id != null)
				return false;
		} else if (!person_id.equals(other.person_id))
			return false;
		if (post_id == null) {
			if (other.post_id != null)
				return false;
		} else if (!post_id.equals(other.post_id))
			return false;
		if (reaction_type_id == null) {
			if (other.reaction_type_id != null)
				return false;
		} else if (!reaction_type_id.equals(other.reaction_type_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reaction [id=" + id + ", reaction_type=" + reaction_type_id + ", person_id=" + person_id + ", post_id="
				+ post_id + "]";
	}
	
	
}
