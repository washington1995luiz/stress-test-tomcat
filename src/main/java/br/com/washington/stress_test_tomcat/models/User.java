package br.com.washington.stress_test_tomcat.models;

import br.com.washington.stress_test_tomcat.events.domain.custom.UserCreatedEvent;
import br.com.washington.stress_test_tomcat.events.domain.custom.UserDisabledEvent;
import br.com.washington.stress_test_tomcat.events.domain.custom.UserEnabledEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Boolean enabled;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = false;
        registerEvent(new UserCreatedEvent(this, "User Created"));
    }

    public void disableAccount(){
        this.enabled = true;
        registerEvent(new UserDisabledEvent(this, "User Disabled"));
    }

    public void enableAccount(){
        this.enabled = false;
        registerEvent(new UserEnabledEvent(this, "User Enabled"));
    }
}
