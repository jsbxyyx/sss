package io.jsbxyyx.config;

import io.jsbxyyx.util.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jsbxyyx
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity globalException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        Result error = Result.error(e.getMessage());
        String str = JsonMapper.writeValueAsString(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(str);
    }

}