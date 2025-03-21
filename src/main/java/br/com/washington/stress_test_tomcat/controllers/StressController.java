package br.com.washington.stress_test_tomcat.controllers;

import br.com.washington.stress_test_tomcat.models.Stress;
import br.com.washington.stress_test_tomcat.services.StressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/stress")
public class StressController {

    private final StressService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void create(@RequestBody Stress stress){
        service.create(stress);
    }
}
