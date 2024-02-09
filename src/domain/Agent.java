package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agent {
    private String codifierName;
    private List<String> documentReferences;
    private Map<String, String> documentTexts;
    private Availability availability;
    private List<AgentInfoSearchedAlert> observers;
    private List<AgentUnavailableAlert> unavailableObservers;

    public Agent(String codifierName) {
        this.codifierName = codifierName;
        this.documentReferences = new ArrayList<>();
        this.documentTexts = new HashMap<>();
        this.availability = Availability.AVAILABLE;
        this.observers = new ArrayList<>();
        this.unavailableObservers = new ArrayList<>();
    }

    public String codifierName() {
        notifyObservers("codifier name was searched");
        return codifierName;
    }

    public Iterable<String> documentReferences() {
        notifyObservers("doc references");
        return documentReferences;
    }

    public Iterable<String> decodifiedDocText(String ref) {
        notifyObservers("document " + ref + " was searched");
        String text = documentTexts.get(ref);
        List<String> decodifiedText = new ArrayList<>();
        // Perform decoding logic on 'text' and store the decoded lines in 'decodifiedText' list

        return decodifiedText;
    }

    public void becomeUnavailable(String unavail) {
        Availability newAvailability = Availability.valueOf(unavail);
        if (availability != newAvailability) {
            availability = newAvailability;
            notifyUnavailableObservers();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String reference : documentReferences) {
            sb.append(documentTexts.get(reference).toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void addDocumentReference(String reference) {
        documentReferences.add(reference);
    }

    public void setDocumentText(String reference, String text) {
        documentTexts.put(reference, text);
    }

    public void addObserver(AgentInfoSearchedAlert observer) {
        observers.add(observer);
    }

    public void removeObserver(AgentInfoSearchedAlert observer) {
        observers.remove(observer);
    }

    public void addUnavailableObserver(AgentUnavailableAlert observer) {
        unavailableObservers.add(observer);
    }

    public void removeUnavailableObserver(AgentUnavailableAlert observer) {
        unavailableObservers.remove(observer);
    }
    
    public void removeDocumentReference(String reference) {
        documentReferences.remove(reference);
    }
    public void notifyObservers(String message) {
        String alertMessage = "Agent " + codifierName + " " + message;
        for (AgentInfoSearchedAlert observer : observers) {
            observer.notifyObservers(alertMessage);
        }
    }

    private void notifyUnavailableObservers() {
        String alertMessage = "Agent " + codifierName + " became " + availability.toString();
        for (AgentUnavailableAlert observer : unavailableObservers) {
            observer.notifyUnavailableObservers(alertMessage);
        }
    }
    private enum Availability {
        AVAILABLE,
        UNAVAILABLE
    }
}