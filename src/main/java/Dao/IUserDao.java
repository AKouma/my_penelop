package Dao;
import my_penelop.*;
import java.util.List;

public interface IUserDao {
	public List<User> findAllUsers();
	   public User findUserById(int id);
	   public int generateIdNewUser();
	   public User findUserByName(String nameResearched);
	   public User createUser(User newUser);
	   public void updateUser(User user);
	   public void deleteUser(User user);
}

