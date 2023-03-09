package com.viraj.springmongo.exceptions;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(String entityId) {
    super("Entity not found with id : " + entityId);
  }
}
