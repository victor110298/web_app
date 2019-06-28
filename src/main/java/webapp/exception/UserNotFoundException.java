package webapp.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("No user found");
    }
}
