package pl.training.jsf.calculator.commons;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ViewRenderer {

    private final ViewResolver viewResolver;

    public void render(@Observes ModelAndView modelAndView) {
        var viewName = modelAndView.viewName();
        var data = modelAndView.data();
        viewResolver.resolve(viewName).render(data);
    }

}
