package pl.training.jsf.calculator.commons;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SuffixViewResolver implements ViewResolver {

    private static final String VIEW_SUFFIX = "View";
    private static final int START_INDEX = 0;

    private final Instance<View> views;
    private Map<String, View> mappings;

    @PostConstruct
    public void createMappings() {
        mappings = views.stream().collect(toMap(this::toViewName, view -> view));
    }

    private String toViewName(View view) {
        var className  = view.getClass().getSimpleName();
        return className.substring(START_INDEX, className.lastIndexOf(VIEW_SUFFIX));
    }

    @Override
    public View resolve(String viewName) {
        return mappings.get(viewName);
    }

}
