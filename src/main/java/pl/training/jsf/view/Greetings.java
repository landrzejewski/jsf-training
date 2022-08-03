package pl.training.jsf.view;

import pl.training.jsf.domain.GreetingEntity;
import pl.training.jsf.domain.GreetingsService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class Greetings {

    @Inject
    private GreetingsService greetingsService;
    private String name = "Unknown";
    private String greeting;
    private List<String> oldGreetings;

    @PostConstruct
    public void init() {
        oldGreetings = greetingsService.getGreetings().stream()
                .map(GreetingEntity::getText)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public List<String> getOldGreetings() {
        return oldGreetings;
    }

    public void submit() {
        greeting = "Hello " + name;
        oldGreetings.add(greeting);
        greetingsService.addGreeting(greeting);
    }


}
