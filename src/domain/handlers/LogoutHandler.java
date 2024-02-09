package domain.handlers;

import domain.interfaces.ILogoutHandler;
import services.SessionManager;

public class LogoutHandler implements ILogoutHandler {

	@Override
	public void logout() {
		System.out.println("LogoutHandler: logout()");
		SessionManager.getInstance().deleteSession();
	}
}
