package br.com.washington.stress_test_tomcat.repositories;

import br.com.washington.stress_test_tomcat.models.Stress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StressRepository extends JpaRepository<Stress, UUID> {
}
