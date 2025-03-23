package br.com.washington.stress_test_tomcat.services;

import br.com.washington.stress_test_tomcat.models.User;

public interface UserService {

        User create(User user);

        User disable(String email);

        User enable(String email);
}