package ru.ukrainskiy.rnd.chatter3.chatter3.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.entity.UserChatterEntity;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;
import ru.ukrainskiy.rnd.chatter3.chatter3.usecase.facade.UserChatterFacade;

@Configuration
@RequiredArgsConstructor
@Transactional
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;
    private final UserChatterFacade userChatterFacade;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {

        setAuthority(authentication);
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter()
                .println(objectMapper.writeValueAsString(Result.success()));
        response.getWriter().flush();
    }

    private void setAuthority(Authentication authentication) {
        UserChatterEntity user = userChatterFacade.findByLogin(authentication.getName()).orElseThrow();
        List<GrantedAuthority> actualAuthority = List.of(new SimpleGrantedAuthority(user.getUserRole().getUserRole()));
        Authentication newAuth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                authentication.getCredentials(),
                actualAuthority);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }
}
