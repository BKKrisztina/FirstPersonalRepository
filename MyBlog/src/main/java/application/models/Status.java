package application.models;

public enum Status {
    DRAFT,
    PUBLISHED,
    DELETED;

    public static Status find(String name) {
        for (Status status : Status.values()) {
            if (status.toString().equalsIgnoreCase(name)) {
                return status;
            }
        }
        return Status.DRAFT;
    }

    public int getDBIndex() {
        return ordinal() + 1;
    }
}
