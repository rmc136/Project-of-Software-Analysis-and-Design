package domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Mission implements PropertyChangeListener {
    private String missionCode;
    private Map<String, Availability> agentAvailability;
    private String responsibleAgent; // Variable to test the code
    private List<String> agents;

    public Mission(String missionCode) {
        this.missionCode = missionCode;
        this.agents = new ArrayList<>();
        this.agentAvailability = new HashMap<>();
    }

    public void addAgent(String agentCode) {
        agents.add(agentCode);
        agentAvailability.put(agentCode, Availability.AVAILABLE);
    }

    public void setAgentAvailability(String agentCode, Availability availability) {
        agentAvailability.put(agentCode, availability);
    }

    public void removeAgent(String agentCode) {
        agents.remove(agentCode);
        agentAvailability.remove(agentCode);
    }

    public Iterable<String> getParticipants() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return agents.stream()
                        .filter(agentCode -> !agentAvailability.get(agentCode).isUnavailable())
                        .iterator();
            }
        };
    }

    public void notifyObservers() {
        MissionInfoSearchedAlert alert = new MissionInfoSearchedAlert("Mission " + missionCode + " info was searched", "message");
        Agent agent = new Agent(missionCode);
        agent.notifyObservers(alert.getMessage());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof AgentUnavailableAlert) {
            AgentUnavailableAlert alert = (AgentUnavailableAlert) evt.getNewValue();
            String subjectName = alert.getSubjectName();

            if (subjectName.equals(responsibleAgent)) {
                removeMissionFromAgent(responsibleAgent);
            } else {
                removeParticipantFromMission(subjectName);
            }
        }

    }

    // Method to test missions without completely implemented user and agent
    public void setResponsibleAgent(String agentCode) {
        this.responsibleAgent = agentCode;
    }

    private void removeParticipantFromMission(String agentCode) {
        // Check if the agent is a participant in the mission
        if (agents.contains(agentCode)) {
            // Remove the agent from the list of participants
            agents.remove(agentCode);
            // Remove the agent's availability information
            agentAvailability.remove(agentCode);
        }
    }

    private void removeMissionFromAgent(String agentCode) {
        Agent agent = findAgent(agentCode);
        if (agent != null) {
            // Remove the mission from the agent's document references
            agent.removeDocumentReference(missionCode);
            // Remove the agent from the mission's participants
            agents.remove(agentCode);
            // Remove the agent's availability information
            agentAvailability.remove(agentCode);
        }
    }

    private Agent findAgent(String agentCode) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mission ").append(missionCode).append(":\n");
        sb.append("Responsible Agent: ").append(responsibleAgent).append("\n");
        sb.append("Participants:\n");
        for (String agentCode : agents) {
            Agent agent = findAgent(agentCode);
            if (agent != null) {
                sb.append(agent.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    private enum Availability {
        AVAILABLE,
        UNAVAILABLE;

        public boolean isUnavailable() {
            return this == UNAVAILABLE;
        }
    }

	public Object getCodeName() {
		return missionCode;
	}
}