package br.com.aprendendospring.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ EmptyResultDataAccessException.class, MyNotFoundException.class })
	public ResponseEntity<?> errorNotFound(Exception e) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<?> forbidden(Exception e) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Mensagem("Acesso negado", HttpStatus.FORBIDDEN.toString()));
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
				.body(new Mensagem("Operação não permitida", HttpStatus.METHOD_NOT_ALLOWED.toString()));
	}
}
