package domain;

public enum Availability {
    AVAILABLE,
    ARRESTED,
    DESERTED,
    ILL,
    DEAD,
    RETIRED;
	
	public boolean isUnavailable() {
        return this != AVAILABLE;
    }
}