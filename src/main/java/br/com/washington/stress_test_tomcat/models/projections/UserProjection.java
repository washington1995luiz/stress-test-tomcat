package br.com.washington.stress_test_tomcat.models.projections;

import java.util.UUID;

public interface UserProjection {
    UUID getId();
    String getName();
    String getEmail();
}
