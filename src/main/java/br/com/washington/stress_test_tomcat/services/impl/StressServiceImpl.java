package br.com.washington.stress_test_tomcat.services.impl;

import br.com.washington.stress_test_tomcat.models.Stress;
import br.com.washington.stress_test_tomcat.repositories.StressRepository;
import br.com.washington.stress_test_tomcat.services.StressService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StressServiceImpl implements StressService {

    private final StressRepository repository;

    @Override
    public void create(Stress stress) {
        stress.create();
        repository.save(stress);
    }
}
