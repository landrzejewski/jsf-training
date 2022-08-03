package pl.training.jsf.calculator.commons;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.RequiredArgsConstructor;

@Controller
@Interceptor
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class Dispatcher {

    // private final ViewRenderer viewRenderer;

    private final Event<ModelAndView> publisher;

    @AroundInvoke
    public Object dispatch(InvocationContext invocationContext) throws Exception {
        var result = invocationContext.proceed();
        if (result instanceof ModelAndView modelAndView) {
            // viewRenderer.render(modelAndView);
            publisher.fire(modelAndView);
        }
        return result;
    }

}
