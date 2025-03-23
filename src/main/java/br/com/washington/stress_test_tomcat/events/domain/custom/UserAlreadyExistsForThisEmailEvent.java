package br.com.washington.stress_test_tomcat.events.domain.custom;

public record UserAlreadyExistsForThisEmailEvent(Object source,
                                                 String message)  {
}
