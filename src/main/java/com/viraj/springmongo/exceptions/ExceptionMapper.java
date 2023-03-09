package com.viraj.springmongo.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.viraj.springmongo.utils.Constants.ADDITIONAL;
import static com.viraj.springmongo.utils.Constants.DEBUG_MESSAGE;
import static com.viraj.springmongo.utils.Constants.DISPLAY_MESSAGE;
import static com.viraj.springmongo.utils.Constants.ERROR_DETAILS;
import static com.viraj.springmongo.utils.Constants.FAILURE;
import static com.viraj.springmongo.utils.Constants.STATUS;

@RestControllerAdvice
@Order(100)
public class ExceptionMapper {
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<Map<String, Object>> toResponse(Throwable ex) {
    Map<String, Object> response = new HashMap<>();
    Map<String, Object> errorDetails = new HashMap<>();
    errorDetails.put(DEBUG_MESSAGE, ex.getMessage());
    errorDetails.put(ADDITIONAL, ex.getClass());
    response.put(STATUS, FAILURE);
    response.put(ERROR_DETAILS, errorDetails);
    if (ex instanceof MethodArgumentNotValidException) {
      // this is validation exception for required fields missing
      errorDetails.put(DISPLAY_MESSAGE, "All required fields not present in request body");
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.internalServerError().body(response);
  }
}
