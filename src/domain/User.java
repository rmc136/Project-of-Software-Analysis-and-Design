package domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

public class User implements PropertyChangeListener{
	private String name;
	private String password;
	private Set<Alert> alerts;
	
	public User(String name, String password) {
		this.setName(name);
		this.setPassword(password);
		this.alerts = new HashSet<>();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Alert> getAlerts() {
		return alerts;
	}
	

	public void propertyChange(PropertyChangeEvent ev) {
        Object newValue = ev.getNewValue();
        if (newValue instanceof AgentUnavailableAlert || newValue instanceof AgentInfoSearchedAlert
                || newValue instanceof MissionInfoSearchedAlert) {
            alerts.add((Alert) newValue);
        }
	}
        
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Name: ").append(name).append(" Pwd: ").append(password).append("\n");
	    sb.append("Has access to the following agents:\n");
	    // Add code to iterate over the agents the user has access to and append their names to the StringBuilder
	    
	    sb.append("Has access to the following missions:\n");
	    // Add code to iterate over the missions the user has access to and append their names to the StringBuilder
	    
	    sb.append("Has received the following alerts:\n");
	    for (Alert alert : alerts) {
	        sb.append("- ").append(alert.getSubjectName()).append(": ").append(alert.getMessage()).append("\n");
	    }
	    return sb.toString();
	}
}
