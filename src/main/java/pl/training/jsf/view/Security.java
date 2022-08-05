package pl.training.jsf.view;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@RequestScoped
@Getter
@Setter
public class Security {

    private String username;
    private String password;
    @Inject
    private SecurityContext securityContext;
    @Inject
    private ExternalContext externalContext;
    @Inject
    private FacesContext facesContext;

    public void login() {
        var authenticationStatus = authenticate();
        var result = securityContext.isCallerInRole("USER");
        var principal  = securityContext.getCallerPrincipal();
        switch (authenticationStatus) {
            case SEND_FAILURE -> facesContext.addMessage(null, new FacesMessage("Invalid user or password"));
            case SUCCESS -> facesContext.addMessage(null, new FacesMessage("Login success"));
            case SEND_CONTINUE -> facesContext.responseComplete();
            case NOT_DONE -> {}
        }
    }

    private AuthenticationStatus authenticate() {
        var request = (HttpServletRequest) externalContext.getRequest();
        var response = (HttpServletResponse) externalContext.getResponse();
        var credentials = AuthenticationParameters.withParams()
                .credential(new UsernamePasswordCredential(username, password));

        return securityContext.authenticate(request, response, credentials);
    }

    public String logout() throws ServletException {
        var request = (HttpServletRequest) externalContext.getRequest();
        request.logout();
        request.getSession().invalidate();
        return "index.xhtml?faces-redirect=true";
    }

}
