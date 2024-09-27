package homework.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestException {

    @ExceptionHandler({
            BookingsNotFoundExceptionId.class,
            CommentNotFoundExceptionId.class,
            CommentNotFoundExceptionId.class,
            FavoriteItemNotFoundExceptionId.class,
            ListingNotFoundExceptionIdId.class,
            ListingRequestNotFoundExceptionId.class,
            RoleNotFoundException.class,
            TransactionNotFoundExceptionId.class,
            UserCredentialNotFoundExceptionId.class,
            UserNotFoundExceptionId.class,
            UserRatingNotFoundException.class

    })
    public ResponseEntity<Object> handleException(Exception e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
