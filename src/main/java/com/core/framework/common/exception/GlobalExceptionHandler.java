package com.core.framework.common.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity exception(ApplicationException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(exception.getErrorCode()));
	}

	@ExceptionHandler(value = NoResultException.class)
	public ResponseEntity noResultException(NoResultException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(401));
	}

	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity emptyResultDataAccessException(EmptyResultDataAccessException exception) {
		return new ResponseEntity<>("", HttpStatus.valueOf(401));
	}

	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
	public ResponseEntity constraintViolationException(SQLIntegrityConstraintViolationException exception) {
		return new ResponseEntity<>("رکورد تکراری", HttpStatus.valueOf(500));
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity constraintViolationException(ConstraintViolationException exception) {
		return new ResponseEntity<>("رکورد تکراری", HttpStatus.valueOf(500));
	}
}
