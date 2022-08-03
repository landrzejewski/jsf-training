package pl.training.jsf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "greetings")
public class GreetingsServlet extends HttpServlet {

    private static final String NAME_PARAMETER = "name";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter(NAME_PARAMETER);
        var htmlResponse = prepareResponse(name);
        var writer = response.getWriter();
        writer.println(htmlResponse);
    }

    private String prepareResponse(String name) {
        return "<html><head><title>Training</title></head><body><p>Hello %s</p></body></html>"
                .formatted(name == null ? "" : name);
    }

}
