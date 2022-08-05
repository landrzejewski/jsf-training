package pl.training.jsf.view.extensions;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Set;

//@ApplicationScoped
public class UserServiceIdentityStore implements IdentityStore {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        var userCredentials = (UsernamePasswordCredential) credential;
        if (!userCredentials.getCaller().equals("user")) {
            return CredentialValidationResult.INVALID_RESULT;
        }
        return new CredentialValidationResult(userCredentials.getCaller(), Set.of("USER"));
    }

}
