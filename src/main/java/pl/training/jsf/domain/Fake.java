package pl.training.jsf.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class Fake {

    @PersistenceContext
    private EntityManager entityManager;

}
