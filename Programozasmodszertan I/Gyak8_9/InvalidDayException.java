package gyak8;

public class InvalidDayException extends Exception{

    public InvalidDayException(){

    }

    public InvalidDayException(String message) {
        super(message);
    }

    public InvalidDayException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDayException(Throwable cause) {
        super(cause);
    }

    public InvalidDayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
