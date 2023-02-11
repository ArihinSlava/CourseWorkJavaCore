package coursework.task;

public enum Type {

    WORK("WORK"),
    PERSONAL("PERSONAL");

    private final String type;


    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
