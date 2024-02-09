package domain;

import java.util.ArrayList;
import java.util.List;

public class Round13CodifierStrategy extends AbstractCodifierStrategy {
    @Override
    public String getName() {
        return "Round13";
    }

    @Override
    public Iterable<String> code(String key, Iterable<String> text) {
        List<String> result = new ArrayList<>();
        for (String line : text) {
            StringBuilder encodedLine = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int offset = (c - base + 13) % 26;
                    encodedLine.append((char) (base + offset));
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
        // Since decoding is the same as encoding in this case,
        // we can reuse the code() method
        return code(key, text);
    }
}