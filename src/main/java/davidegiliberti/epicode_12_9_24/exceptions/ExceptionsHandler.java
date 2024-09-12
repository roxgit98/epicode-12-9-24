package davidegiliberti.epicode_12_9_24.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseStatusException handleNotFoundException(NotFoundExceptions ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseStatusException handleBadRequestException(BadRequestException ex) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseStatusException handleGenericException(Exception ex) {
        return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "errore del server");
    }

}
