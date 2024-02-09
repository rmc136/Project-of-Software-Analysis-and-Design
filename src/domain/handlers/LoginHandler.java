package domain.handlers;

import domain.interfaces.ILoginHandler;
import domain.stubs.ObtainUsersHandler;
import services.SessionManager;

public class LoginHandler extends ObtainUsersHandler implements ILoginHandler {

	@Override
	public boolean login(String username, String password) {
		boolean success = !username.equals("fail");
		
		if (success)
			SessionManager.getInstance().createSession(username);
		return success;
	}

}

