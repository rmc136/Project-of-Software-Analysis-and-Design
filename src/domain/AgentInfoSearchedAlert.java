package domain;

public class AgentInfoSearchedAlert implements Alert {
    private String subjectName;
    private String message;

    public AgentInfoSearchedAlert(String subjectName, String message) {
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

    public void notifyObservers(String alertMessage) {
        System.out.println(alertMessage);  // Or any other notification logic you want to implement
    }
}