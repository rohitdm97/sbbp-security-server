package com.rohitdm97.sbbpserver.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Log4j2
@Setter
public class AuthenticationFilterImpl extends AbstractAuthenticationProcessingFilter {

    public static final String ACCESS_TOKEN_REQUEST_HEADER = "access_token";

    private static final AntPathRequestMatcher pathMatcher = new AntPathRequestMatcher("/**");

    public AuthenticationFilterImpl(AuthenticationManager authenticationManager) {
        super(pathMatcher);
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        long time = System.nanoTime();
        request.setAttribute("time", time);
        if (HttpStatus.valueOf(response.getStatus()).is2xxSuccessful()) {
            return super.requiresAuthentication(request, response);
        }
        // do not process if response is already set to non 2xx
        return false;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String accessToken = request.getHeader(ACCESS_TOKEN_REQUEST_HEADER);
        if (accessToken == null) {
            // might check cookie
            throw new AuthenticationServiceException("no access token found");
        }
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(null, accessToken));
    }

    // do not call super.successfulAuthentication(...), it redirects the request to "/"
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

}
