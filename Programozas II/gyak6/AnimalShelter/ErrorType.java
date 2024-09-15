package AnimalShelter;

public enum ErrorType {
    INVALID_NAME("Az állat neve érvénytelen!"),
    INVALID_WEIGHT("Az állat tömege érvénytelen!"),
    INVALID_AGE("Az állat életkora érvénytelen!"),
    INVALID_SPECIES("Az állat faja érvénytelen!");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}