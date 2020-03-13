package jp.gr.java_conf.ak.akanash.security;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@SuppressWarnings("serial")
public class CurrentUser implements Serializable {

    private Authentication auth;

    @PostConstruct
    protected void init() {
        this.auth = SecurityContextHolder.getContext().getAuthentication();
    }

    public String getUsername() {
        return this.auth != null ? this.auth.getName() : null;
    }
}