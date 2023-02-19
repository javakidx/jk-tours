package idv.jk.handler;

import idv.jk.exception.Error;
import idv.jk.exception.ResourceAlreadyExistsException;
import idv.jk.exception.ResourceNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RequestValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleResourceNotFoundException(ResourceNotFoundException ex) {
        final var error = new Error(ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Error> handDuplicateKeyException(DuplicateKeyException ex) {
        final var error = new Error("Tour name already exists");
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Error> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        final var error = new Error(ex.getMessage());
        return ResponseEntity.status(400).body(error);
    }
}
