//package com.example.accountbook.config;
//
//import com.example.accountbook.domain.Customer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.InputMismatchException;
//
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    public CustomAuthenticationFilter(final AuthenticationManager authenticationManager){
//        super.setAuthenticationManager(authenticationManager);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        final UsernamePasswordAuthenticationToken authRequest;
//        try {
//            final Customer user = new ObjectMapper().readValue(request.getInputStream(),Customer.class);
//            authRequest = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
//        }catch (IOException exception){
//            throw new RuntimeException();
//        }
//        setDetails(request,authRequest);
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
//}
