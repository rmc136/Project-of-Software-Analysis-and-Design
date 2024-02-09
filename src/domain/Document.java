package domain;

public class Document implements Cloneable {
    private String content;
    private DocNature nature;

    public Document(String content, DocNature nature) {
        this.content = content;
        this.nature = nature;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DocNature getNature() {
        return nature;
    }

    public void setNature(DocNature nature) {
        this.nature = nature;
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                ", nature=" + nature.getWord() +
                '}';
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // This should never happen
        }
    }
}