package domain;

import java.util.ArrayList;
import java.util.List;

public class VigenereCodifierStrategy extends AbstractCodifierStrategy {
    private static final int ALPHABET_SIZE = 26;

    @Override
    public String getName() {
        return "Vigenere";
    }

    @Override
    public Iterable<String> code(String key, Iterable<String> text) {
        List<String> result = new ArrayList<>();
        int keyLength = key.length();
        int keyIndex = 0;

        for (String line : text) {
            StringBuilder encodedLine = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int keyChar = key.charAt(keyIndex % keyLength) - base;
                    int textChar = c - base;
                    int encodedChar = (textChar + keyChar) % ALPHABET_SIZE;
                    encodedLine.append((char) (base + encodedChar));
                    keyIndex++;
                } else {
                    encodedLine.append(c);
                }
            }
            result.add(encodedLine.toString());
        }
        return result;
    }

    @Override
    public Iterable<String> decode(String key, Iterable<String> text) {
        List<String> result = new ArrayList<>();
        int keyLength = key.length();
        int keyIndex = 0;

        for (String line : text) {
            StringBuilder decodedLine = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int keyChar = key.charAt(keyIndex % keyLength) - base;
                    int textChar = c - base;
                    int decodedChar = (textChar - keyChar + ALPHABET_SIZE) % ALPHABET_SIZE;
                    decodedLine.append((char) (base + decodedChar));
                    keyIndex++;
                } else {
                    decodedLine.append(c);
                }
            }
            result.add(decodedLine.toString());
        }
        return result;
    }
}