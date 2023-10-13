package com.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.MessageFormat;

import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
@ControllerAdvice
public class ControllerErrorResp extends ResponseEntityExceptionHandler {    
    
    private static final long serialVersionUID = 8315180825394499599L;

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<Object> handleNotFoundException(final RuntimeException runtimeException,
                                                          final WebRequest webRequest) {
        final NotFoundExceptions notFoundExceptions = (NotFoundExceptions) runtimeException;
        final StatusExceptions statusExceptions = new StatusExceptions(HttpStatus.NOT_FOUND.toString(), notFoundExceptionMessage(notFoundExceptions));
        log.error("EntityNotFoundException: {}", statusExceptions);
        return handleExceptionInternal(runtimeException, statusExceptions, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<Object> handleGatewayException(final RuntimeException runtimeException,
                                                         final WebRequest webRequest) {
        final MessageException messageException = (MessageException) runtimeException;
        StatusExceptions statusExceptions = new StatusExceptions(HttpStatus.SERVICE_UNAVAILABLE.toString(), messageException.getMessage());
        if (!isEmpty(messageException.getErrors())) {
        	statusExceptions = new StatusExceptions(HttpStatus.SERVICE_UNAVAILABLE.toString(), messageException.getErrors());
        }
        final String errorMessage = MessageFormat.format("MessageException: {0}", statusExceptions);
        log.error(errorMessage, "exception", runtimeException);
        return handleExceptionInternal(runtimeException, statusExceptions, new HttpHeaders(),
                HttpStatus.SERVICE_UNAVAILABLE, webRequest);
    }

    private static String notFoundExceptionMessage(final NotFoundExceptions notFoundExceptions) {
        return String.format("%s %s not found", notFoundExceptions.getTypes(), notFoundExceptions.getId());
    }
}


