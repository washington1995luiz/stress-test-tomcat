package br.com.washington.stress_test_tomcat.events.domain;

import br.com.washington.stress_test_tomcat.events.domain.custom.UserAlreadyExistsForThisEmailEvent;
import br.com.washington.stress_test_tomcat.events.domain.custom.UserCreatedEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class UserEventListener {

    @EventListener
    void userCreatedHandler(UserCreatedEvent event){
       log.info(event.message());
       log.info(event.source().getEmail());
    }

    @EventListener
    void error1(UserAlreadyExistsForThisEmailEvent event){
        log.info("1");
    }

    @EventListener
    void error2(UserAlreadyExistsForThisEmailEvent event){
        log.info("2");
    }
    @Async
    @EventListener
    void error3(UserAlreadyExistsForThisEmailEvent event){
        log.info("3");
    }
}
