package pl.training.jsf.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.Setter;

import java.util.logging.Logger;

@LogExecutionTime
@Interceptor
public class Stopper {

    @Setter
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object measure(InvocationContext invocationContext) throws Exception {
        long startTime = System.nanoTime();
        var result = invocationContext.proceed();
        long totalTime = System.nanoTime() - startTime;
        var methodName = invocationContext.getMethod().getName();
        logger.info("### Execution time for method %s equals %d ns".formatted(methodName, totalTime));
        return result;
    }

}
