package gyak8;

public class DayOutOfBoundsException extends InvalidDayException{

    public DayOutOfBoundsException(){

    }

    public DayOutOfBoundsException(String message) {
        super(message);
    }

    public DayOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DayOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public DayOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
