package pl.training.jsf;

import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/*@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:global/Training",
        callerQuery = "select password from caller where name = ?",
        groupsQuery = "select name from groups where caller_name = ?"
)
@DataSourceDefinition(
        name = "java:global/Training",
        className = "org.h2.jdbcx.JdbcDataSource",
        url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=1"
)*/
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
