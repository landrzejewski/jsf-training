package pl.training.jsf.view;

import lombok.Setter;
import pl.training.jsf.domain.Product;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ConversationScoped
public class Cart implements Serializable {

    @Inject
    @Setter
    private Conversation conversation;

    public void start() {
        conversation.begin();
    }

    public void addProduct(Product product) {
        // logic
    }

    public void confirmOrder() {
        conversation.end();
    }

}
