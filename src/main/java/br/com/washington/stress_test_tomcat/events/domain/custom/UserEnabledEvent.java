package br.com.washington.stress_test_tomcat.events.domain.custom;

import br.com.washington.stress_test_tomcat.models.User;

public record UserEnabledEvent(User source, String message) {
}
