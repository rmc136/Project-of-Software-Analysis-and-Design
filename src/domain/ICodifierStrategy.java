package domain;

public interface ICodifierStrategy {
    String getName();

    Iterable<String> code(String key, Iterable<String> text);

    Iterable<String> decode(String key, Iterable<String> text);
}