package example.rest;

import example.api.ErrorResponseDto;
import example.service.UniqueIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final UniqueIdService service;

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(NOT_FOUND)
    public void handleExceptionNotFound(HttpServletRequest request, Exception ex) {
        log.debug("context=\"Could not find resource\", path=\"{}\"", request.getServletPath(), ex);
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class})
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDto handleNestedExceptionBadRequest(HttpServletRequest request, Exception ex) {
        return createResponse(request, "Invalid Argument Received", ex);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(METHOD_NOT_ALLOWED)
    @ResponseBody
    public ErrorResponseDto handleExceptionMethodNotAllowed(HttpServletRequest request, Exception ex) {
        return createResponse(request, "HTTP Method not supported", ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseDto handleException(HttpServletRequest request, Exception ex) {
        return createResponse(request, "Oops!", ex);
    }

    private ErrorResponseDto createResponse(HttpServletRequest request, String context, Exception ex) {
        final String referenceId = service.createId(7);
        log.debug("context=\"{}\", ref=\"{}\", path=\"{}\", query=\"{}\", message=\"{}\"",
                context,
                referenceId,
                request.getServletPath(),
                request.getQueryString(),
                ex.getMessage(),
                ex);
        return ErrorResponseDto.builder()
                .referenceId(referenceId)
                .description(context)
                .build();
    }
}
