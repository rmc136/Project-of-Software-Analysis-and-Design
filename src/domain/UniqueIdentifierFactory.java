package domain;
import java.util.HashMap;
import java.util.Map;

public class UniqueIdentifierFactory {
    private static UniqueIdentifierFactory instance;
    private Map<DocNature, Integer> sequenceMap;

    private UniqueIdentifierFactory() {
        sequenceMap = new HashMap<>();
    }

    public static synchronized UniqueIdentifierFactory getInstance() {
        if (instance == null) {
            instance = new UniqueIdentifierFactory();
        }
        return instance;
    }

    public synchronized String getIdentifier(DocNature dn) {
        int sequence = sequenceMap.getOrDefault(dn, 1);
        String identifier = dn.getWord() + sequence;
        sequenceMap.put(dn, sequence + 1);
        return identifier;
    }
}