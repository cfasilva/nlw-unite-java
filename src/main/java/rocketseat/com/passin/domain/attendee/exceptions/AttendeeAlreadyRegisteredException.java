package rocketseat.com.passin.domain.attendee.exceptions;

public class AttendeeAlreadyRegisteredException extends RuntimeException {
    public AttendeeAlreadyRegisteredException(final String message) {
        super(message);
    }
}
