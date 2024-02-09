package domain;

import domain.interfaces.IAddDocForAgentHandler;
import domain.interfaces.ICreateAgentHandler;
import domain.interfaces.ICreateMissionHandler;
import domain.interfaces.ILoginHandler;
import domain.interfaces.ILogoutHandler;
import domain.interfaces.IOCT;
import domain.interfaces.IReadDocAgentHandler;
import domain.interfaces.ISearchAgentInfoHandler;
import domain.interfaces.ISearchMissionInfoHandler;
import domain.interfaces.ISetUnavailabilityHandler;
import domain.handlers.LogoutHandler;
import domain.handlers.ReadDocAgentHandler;
import domain.handlers.AddDocForAgentHandler;
import domain.handlers.SetUnavailabilityHandler;
import domain.handlers.SearchMissionInfoHandler;
import domain.handlers.SearchAgentInfoHandler;
import domain.handlers.CreateMissionHandler;
import domain.handlers.CreateAgentHandler;
import domain.handlers.LoginHandler;

public class OCT implements IOCT {
	private UserCatalog userCatalog;
	private MissionCatalog missionCatalog;
	private AgentCatalog agentCatalog;
	
	public OCT() {
		userCatalog = new UserCatalog();
		missionCatalog = new MissionCatalog();
		agentCatalog = new AgentCatalog();
	}
	
	public String getUsersInfo(String name) {
		User user = userCatalog.getUserByName(name);
		if (user != null) {
			return user.toString();
		} else {
			return "User not found.";
		}
	}

	@Override
	public ILoginHandler getLoginHandler() {
		return new LoginHandler();
	}

	@Override
	public ILogoutHandler getLogoutHandler() {
		return new LogoutHandler();
	}

	@Override
	public ICreateAgentHandler getCreateAgentHandler() {
		return new CreateAgentHandler();
	}

	@Override
	public IAddDocForAgentHandler getAddDocForAgentHandler() {
		return new AddDocForAgentHandler();
	}

	@Override
	public IReadDocAgentHandler getReadDocAgentHandler() {
		return new ReadDocAgentHandler();
	}

	@Override
	public ISetUnavailabilityHandler getSetUnavailabilityHandler() {
		return new SetUnavailabilityHandler();
	}

	@Override
	public ICreateMissionHandler getCreateMissionHandler() {
		return new CreateMissionHandler();
	}

	@Override
	public ISearchAgentInfoHandler getSearchAgentInfoHandler() {
		return new SearchAgentInfoHandler();
	}

	@Override
	public ISearchMissionInfoHandler getSearchMissionInfoHandler() {
		return new SearchMissionInfoHandler();
	}

}
