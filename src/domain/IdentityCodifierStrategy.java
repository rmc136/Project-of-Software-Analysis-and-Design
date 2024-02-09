package domain;

public class IdentityCodifierStrategy extends AbstractCodifierStrategy {
    @Override
    public String getName() {
        return "Identity";
    }

    @Override
    public Iterable<String> code(String key, Iterable<String> text) {
        return text; // Return the input text unchanged
    }

    @Override
    public Iterable<String> decode(String key, Iterable<String> text) {
        return text; // Return the input text unchanged
    }
}