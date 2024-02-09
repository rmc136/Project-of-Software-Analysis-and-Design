package domain;

import java.util.ArrayList;
import java.util.List;

public class AgentCatalog {
    private List<Agent> agents;

    public AgentCatalog() {
        agents = new ArrayList<>();
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public Agent getAgentByCodifierName(String codifierName) {
        for (Agent agent : agents) {
            if (agent.codifierName().equals(codifierName)) {
                return agent;
            }
        }
        return null;
    }
}
