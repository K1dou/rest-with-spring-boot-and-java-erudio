package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.dto.securityV1.AccountCredentialsDTO;
import com.K1dou.restwithspringbootandjava.dto.securityV1.TokenDTO;
import com.K1dou.restwithspringbootandjava.repository.UserRepository;
import com.K1dou.restwithspringbootandjava.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity signin (AccountCredentialsDTO dto) {
        try {
            var userName = dto.getUsername();
            var password = dto.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));

            var user = userRepository.findByUsername(userName);

            var tokenResponse = new TokenDTO();
            if (user!=null){
                tokenResponse = tokenProvider.createAccessToken(userName,user.getRoles());
            }else {
                throw new UsernameNotFoundException("Username "+ userName + " not found!");
            }


        return ResponseEntity.ok(tokenResponse);
        }catch (Exception e){
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }
}
