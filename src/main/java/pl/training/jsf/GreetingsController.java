package pl.training.jsf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "greetings")
public class GreetingsController extends HttpServlet {

    private static final String NAME_PARAMETER = "name";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String GREETINGS_VIEW = "/greetings.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter(NAME_PARAMETER);
        // run logic
        request.setAttribute(NAME_ATTRIBUTE, name); // per request
        // request.getSession().setAttribute(); // per session
        // getServletContext().setAttribute(); // per application
        getServletContext().getRequestDispatcher(GREETINGS_VIEW)
                .forward(request, response);
    }

}
