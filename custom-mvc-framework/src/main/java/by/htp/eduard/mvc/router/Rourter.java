package by.htp.eduard.mvc.router;

import java.io.IOException;

import javax.servlet.ServletException;

public interface Rourter {
	
	public void route(String viewName) throws ServletException, IOException;

}
