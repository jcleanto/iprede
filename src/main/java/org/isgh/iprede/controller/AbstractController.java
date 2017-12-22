package org.isgh.iprede.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.isgh.iprede.exception.RestException;
import org.isgh.iprede.exception.RestExceptionCode;
import org.isgh.iprede.security.AccountCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class AbstractController {
	
	private final static Logger logger = LoggerFactory.getLogger(AbstractController.class);

    String getAuthorizedUserName() {

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//        if (auth == null || auth.getPrincipal() == null || !(auth.getPrincipal() instanceof AppUser)) {
//            // hack for development
//            if ("dev".equals(System.getProperty("spring.profiles.active"))) {
//                return "test";
//            }
        if (auth != null && !(auth.getPrincipal() instanceof AccountCredentials)) {
            logger.error("Nenhum usuario autorizado encontrado");
            throw new RestException("Nenhum usuario autorizado encontrado", RestExceptionCode.FC_RE_001);
        }
        return ((AccountCredentials)auth.getPrincipal()).getUsername();
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
