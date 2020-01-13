package by.htp.eduard.service;

import by.htp.eduard.entities.Authentication;
import by.htp.eduard.entities.User;

public interface AuthenticationService {
	
	User signIn(Authentication authentication);
	User forgetPassword(Authentication authentication);

}
