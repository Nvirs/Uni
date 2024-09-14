package SajátKivételek;

// extends Exception helyett használható az extends RuntimeException is, így egy nem ellenőrzött kivétellé válik
// ezért a FriendList.java-ban lévő addFriend metódusnál elhagyható a throws InvalidFriendNameException
public class InvalidFriendNameException extends RuntimeException {
    private final ErrorCode errorCode;

    public InvalidFriendNameException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidFriendNameException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}