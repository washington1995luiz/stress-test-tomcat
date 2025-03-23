package br.com.washington.stress_test_tomcat.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistsForThisEmail extends ResponseStatusException {

    public UserAlreadyExistsForThisEmail() {
        super(HttpStatus.CONFLICT, "This email already exists.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
