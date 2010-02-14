package org.springframework.security.web.authentication.preauth;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;


/**
 * {@link org.springframework.security.core.Authentication} implementation for pre-authenticated
 * authentication.
 *
 * @author Ruud Senden
 * @since 2.0
 */
public class PreAuthenticatedAuthenticationToken extends AbstractAuthenticationToken {
    private final Object principal;
    private final Object credentials;

    /**
     * Constructor used for an authentication request. The {@link
     * org.springframework.security.core.Authentication#isAuthenticated()} will return
     * <code>false</code>.
     *
     * @param aPrincipal
     *            The pre-authenticated principal
     * @param aCredentials
     *            The pre-authenticated credentials
     */
    public PreAuthenticatedAuthenticationToken(Object aPrincipal, Object aCredentials) {
        super(null);
        this.principal = aPrincipal;
        this.credentials = aCredentials;
    }


    /**
     * Constructor used for an authentication response. The {@link
     * org.springframework.security.core.Authentication#isAuthenticated()} will return
     * <code>true</code>.
     *
     * @param aPrincipal
     *            The authenticated principal
     * @param anAuthorities
     *            The granted authorities
     */
    public PreAuthenticatedAuthenticationToken(Object aPrincipal, Object aCredentials, Collection<GrantedAuthority> anAuthorities) {
        super(anAuthorities);
        this.principal = aPrincipal;
        this.credentials = aCredentials;
        setAuthenticated(true);
    }

    /**
     * Get the credentials
     */
    public Object getCredentials() {
        return this.credentials;
    }

    /**
     * Get the principal
     */
    public Object getPrincipal() {
        return this.principal;
    }

}
