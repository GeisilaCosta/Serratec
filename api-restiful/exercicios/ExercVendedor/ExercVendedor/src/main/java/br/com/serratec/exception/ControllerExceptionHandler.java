package br.com.serratec.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> erros = new ArrayList<>();
		for (FieldError f : ex.getBindingResult().getFieldErrors()) {
			erros.add(f.getField() + " : " + f.getDefaultMessage());
		}

		ErroResposta er = new ErroResposta(status.value(), "Existem campos invalidos", LocalDate.now(), erros);
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErroResposta er = new ErroResposta(status.value(), "Campos inválidos foram inseridos, favor verificar!",
				LocalDate.now(), null);
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}

	@ExceptionHandler(EmailException.class)
	protected ResponseEntity<Object> handleEmailException(EmailException ex, HttpHeaders headers, HttpStatusCode status,
			WebRequest request) {

		ErroResposta er = new ErroResposta(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage(), LocalDate.now(), null);
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	    protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	        ErroResposta er = new ErroResposta(HttpStatus.NOT_FOUND.value(), "Verifique se você possui a informação no banco de dados.", LocalDateTime.now(), ex.getMessage(), null, "Recurso não encontrado");
	        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
	    }

}
