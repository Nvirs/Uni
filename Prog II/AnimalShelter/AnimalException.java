package AnimalShelter;

public class AnimalException extends Exception {
    private final ErrorType errorType;

    public AnimalException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}