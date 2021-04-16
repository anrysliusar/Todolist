package com.sliusar.todolist.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sliusar.todolist.dao.UserDAO;
import com.sliusar.todolist.models.AuthToken;
import com.sliusar.todolist.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private UserDAO userDAO;
    public LoginFilter(String URL, AuthenticationManager manager, UserDAO userDAO) {
        setFilterProcessesUrl(URL);
        setAuthenticationManager(manager);
        this.userDAO = userDAO;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        User user = null;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Authentication authenticate = null;
        if (user != null) {
            authenticate = getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword())
            );
        }
        return authenticate;
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain, Authentication authResult
    ) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .signWith(SignatureAlgorithm.HS512, "Hooray".getBytes())
                .compact();

        User user = userDAO.findUserByUsername(authResult.getName());
        AuthToken authToken = new AuthToken();
        authToken.setToken(token);
        authToken.setUser(user);
        user.getAuthTokens().add(authToken);
        userDAO.save(user);
        response.addHeader("Authorization", "Bearer " + token);
        chain.doFilter(request, response);
    }

}
