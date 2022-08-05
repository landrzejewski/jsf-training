package pl.training.jsf.view.extensions;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import java.io.IOException;

@FacesComponent(createTag = true, tagName = "hello", namespace = "http://training.pl/components")
public class HelloComponent extends UIComponentBase {

    private static final String NAME_ATTRIBUTE = "name";

    @Override
    public String getFamily() {
        return "Custom";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        var name = (String) getAttributes().get(NAME_ATTRIBUTE);
        var writer = context.getResponseWriter();
        writer.startElement("p", this);
        writer.write("Hello " + name);
        writer.endElement("p");
    }

}
