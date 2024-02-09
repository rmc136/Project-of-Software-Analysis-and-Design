package domain;

import java.util.ArrayList;
import java.util.List;

public class MissionCatalog {
	private List<Mission> missions;
	
	public MissionCatalog() {
		missions = new ArrayList<>();
	}
	
	public void addMission(Mission mission) {
		missions.add(mission);
	}
	
	public void removeMission(Mission mission) {
		missions.remove(mission);
	}
	
    public Mission getMissionByCodeName(String codeName) {
        for (Mission mission : missions) {
            if (mission.getCodeName().equals(codeName)) {
                return mission;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mission Catalog:\n");
        for (Mission mission : missions) {
            sb.append(mission.toString()).append("\n");
        }
        return sb.toString();
    }
}
