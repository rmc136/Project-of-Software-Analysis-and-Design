package domain.interfaces;

/**
 * The interface for the logout use case
 * 
 * @author fmartins
 *
 */
public interface ILogoutHandler {

	/**
	 * Ends the session for the current authenticated user.
	 */
	void logout();

}