package com.fundatec.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<ApiErrorDTO> handleConflictException(ConflitoException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DadosErradosException.class)
    public ResponseEntity<ApiErrorDTO> handleWrongDataException(DadosErradosException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ImpossivelCriarException.class)
    public ResponseEntity<ApiErrorDTO> handleUncreatable(ImpossivelCriarException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<ApiErrorDTO> handleMethodNotAllowed(NaoPermitidoException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<ApiErrorDTO> handleNofFound(ObjetoNaoEncontradoException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDTO> handleUnkownError(Throwable e) {
        return new ResponseEntity<>(new ApiErrorDTO("não temos uma excessão para isso ainda",
                LocalDateTime.now()), HttpStatus.I_AM_A_TEAPOT);
    }
}