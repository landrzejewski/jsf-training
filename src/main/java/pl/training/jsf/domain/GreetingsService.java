package pl.training.jsf.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class GreetingsService {

    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private TimeProvider timeProvider;

    public void addGreeting(String text) {
        var greeting = new GreetingEntity();
        greeting.setText(text);
        greeting.setTimestamp(timeProvider.getTimestamp());
        entityManager.persist(greeting);
    }

    public List<GreetingEntity> getGreetings() {
        return entityManager.createNamedQuery(GreetingEntity.GET_ALL, GreetingEntity.class)
                .getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setTimeProvider(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

}
