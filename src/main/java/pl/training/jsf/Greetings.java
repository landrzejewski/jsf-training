package pl.training.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Greetings {

    private String name = "Unknown";
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return message;
    }

    public void submit() {
        message = "Hello " + name;
    }

}
