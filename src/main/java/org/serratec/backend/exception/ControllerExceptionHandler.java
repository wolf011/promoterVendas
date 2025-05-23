package org.serratec.backend.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> erros = new ArrayList<>();

        for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
            erros.add(erro.getField() + ":" + erro.getDefaultMessage());
        }

        ErroResposta erroResposta = new ErroResposta(status.value(), "Existem campos inválidos", LocalDateTime.now(), erros);
        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
    }


    @ExceptionHandler(LancamentoVendasException.class)
    protected ResponseEntity<Object> handleNotFoundDataException(LancamentoVendasException ex) {
        ErroResposta erroResposta = new ErroResposta(HttpStatus.NOT_FOUND.value(), "Dados não encontrados:", LocalDateTime.now(),ex.getMessage());
        return new ResponseEntity<>(erroResposta,HttpStatus.NOT_FOUND);
    }



}
