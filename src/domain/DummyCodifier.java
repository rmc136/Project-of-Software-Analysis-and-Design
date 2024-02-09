package domain;

public class DummyCodifier implements ICodifierStrategy {
    // attributes to connect to the concrete adapter

    public DummyCodifier() {
    }

    @Override
    public String getName() {
        return "Dummy";
    }

    @Override
    public Iterable<String> code(String key, Iterable<String> text) {
        // Implementation for code method
        return null;
    }

    @Override
    public Iterable<String> decode(String key, Iterable<String> text) {
        // Implementation for decode method
        return null;
    }
}