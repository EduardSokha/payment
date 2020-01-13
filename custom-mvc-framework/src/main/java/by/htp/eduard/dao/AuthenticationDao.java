package by.htp.eduard.dao;

import by.htp.eduard.entities.Authentication;
import by.htp.eduard.entities.User;

public interface AuthenticationDao {
	
	User signIn(Authentication authentication);
	User forgetPassword(Authentication authentication);
	

}
