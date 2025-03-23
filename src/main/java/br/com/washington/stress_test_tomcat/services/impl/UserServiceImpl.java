package br.com.washington.stress_test_tomcat.services.impl;

import br.com.washington.stress_test_tomcat.events.domain.custom.UserAlreadyExistsForThisEmailEvent;
import br.com.washington.stress_test_tomcat.exceptions.UserAlreadyExistsForThisEmail;
import br.com.washington.stress_test_tomcat.models.User;
import br.com.washington.stress_test_tomcat.repositories.UserRepository;
import br.com.washington.stress_test_tomcat.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public User create(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            eventPublisher.publishEvent(new UserAlreadyExistsForThisEmailEvent(this, "userAlready"));
            throw new UserAlreadyExistsForThisEmail();
        }
        User newUser = new User(user.getName(), user.getEmail(), user.getPassword());
        return userRepository.save(newUser);
    }

    @Override
    public User disable(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        user.disableAccount();
        return userRepository.save(user);
    }

    @Override
    public User enable(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        user.enableAccount();
        return userRepository.save(user);
    }
}
