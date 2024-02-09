package domain;

public class MissionInfoSearchedAlert implements Alert {
    private String subjectName;
    private String message;

    public MissionInfoSearchedAlert(String subjectName, String message) {
        this.subjectName = subjectName;
        this.message = message;
    }

    @Override
    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String getMessage() {
        return message;
    }
}