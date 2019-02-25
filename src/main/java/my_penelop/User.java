package my_penelop;

import java.util.ArrayList;
import java.util.List;

//import myPenelop.User;

public class User {
	
	private int id;
	private String name;
	List<String> contactUser;//Store all user contact
	
	//Constructor:
	public User(int id, String name, ArrayList<String> contactUser) 
	{
		this.id = id ;
		this.name = name;
		this.contactUser = contactUser;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactUser == null) ? 0 : contactUser.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (contactUser == null) {
			if (other.contactUser != null)
				return false;
		} else if (!contactUser.equals(other.contactUser))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", contactUser=" + contactUser + "]";
	}
	
	public int getId(User user) {
		
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getContact()
	{
		return null;
	}
	
	
	public void setContact(ArrayList<String> contactUser)
	{
		
	}
}
