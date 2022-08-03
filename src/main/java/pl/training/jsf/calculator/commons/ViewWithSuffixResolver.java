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
public class ViewWithSuffixResolver implements ViewResolver {

    private static final String VIEW_SUFFIX = "View";

    private final Instance<View> views;
    private Map<String, View> mappings;

    @PostConstruct
    public void creatMappings() {
        mappings = views.stream().collect(toMap(this::toViewName, view -> view));
    }

    private String toViewName(View view) {
        var className = view.getClass().getSimpleName();
        return className.substring(0, className.lastIndexOf(VIEW_SUFFIX));
    }

    @Override
    public View getView(String viewName) {
        return mappings.get(viewName);
    }

}
