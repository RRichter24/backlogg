package dev.iceb.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String post_text;
	private LocalDateTime post_date;
	private Integer person_id;
	
	public Post() {
		post_date = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPost_text() {
		return post_text;
	}

	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}

	public LocalDateTime getPost_date() {
		return post_date;
	}

	public void setPost_date(LocalDateTime post_date) {
		this.post_date = post_date;
	}

	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((person_id == null) ? 0 : person_id.hashCode());
		result = prime * result + ((post_date == null) ? 0 : post_date.hashCode());
		result = prime * result + ((post_text == null) ? 0 : post_text.hashCode());
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
		Post other = (Post) obj;
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
		if (post_date == null) {
			if (other.post_date != null)
				return false;
		} else if (!post_date.equals(other.post_date))
			return false;
		if (post_text == null) {
			if (other.post_text != null)
				return false;
		} else if (!post_text.equals(other.post_text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", post_text=" + post_text + ", post_date=" + post_date + ", person_id=" + person_id
				+ "]";
	}
	
	
}
