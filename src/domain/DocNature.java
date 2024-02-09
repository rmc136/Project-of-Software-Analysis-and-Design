package domain;

public enum DocNature {
    TO_AGENT("ToAg"),
    FROM_AGENT("FrAg"),
    INTERNAL("Intr");

    private String word;

    DocNature(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}