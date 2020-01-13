package by.htp.eduard.dao;

import java.util.List;

import by.htp.eduard.entities.ListAccountsAndCards;
import by.htp.eduard.entities.User;

public interface UserDao {
	
	List<User> getAllUsers();
	List<ListAccountsAndCards> getAccountsAndCards();
	User getUserById(Integer id);
	User saveUser(User user);
	User updateUser(User user);
	void deleteUser(Integer id);

}
