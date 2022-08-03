package pl.training.jsf.calculator.commons;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Controller
@Interceptor
public class ControllerInterceptor {

    @AroundInvoke
    public Object dispatch(InvocationContext invocationContext) throws Exception {
        var modelAndView = (ModelAndView) invocationContext.proceed();
        System.out.println(modelAndView.getViewName());
        return modelAndView;
    }

}
