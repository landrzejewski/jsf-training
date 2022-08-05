package pl.training.jsf;

import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

@EmbeddedIdentityStoreDefinition(@Credentials(
    callerName = "user",
    password = "123",
    groups = "USER"
))
@CustomFormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue(
            loginPage = "/login.xhtml",
            errorPage = ""
    )
)
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
}
