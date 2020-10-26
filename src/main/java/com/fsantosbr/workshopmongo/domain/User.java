package com.fsantosbr.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/* Both "@Document"  and "@Document(collection="user")" work fine.
	 * The first turns the class name into collections with the first letter in lower case
	 */
	
	@Id
	private String id;
	private String name;
	private String email;
	
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
	// Spring Jpa: To set that a collection (in mongoDB) is referring to another collection (mongoDb) we use @DBRef
	// The '(lazy = true)' parameter sets that this collection will be loaded if (only) called/opened. If we retrieve the users, the collection won't load at first
	
	
	public User() {}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
