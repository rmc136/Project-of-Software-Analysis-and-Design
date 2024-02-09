package domain;

public class AgentUnavailableAlert implements Alert {
    private String subjectName;
    private String message;

    public AgentUnavailableAlert(String subjectName, String message) {
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

    public void notifyUnavailableObservers(String alertMessage) {
        System.out.println(alertMessage);  // Or any other notification logic you want to implement
    }
}