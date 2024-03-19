package com.K1dou.restwithspringbootandjava.securityJwt;

import com.K1dou.restwithspringbootandjava.dto.securityV1.TokenDTO;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {


    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";

    @Value("${security.jwt.token.expire-lenght:3600000}")
    private long validityInMilliseconds = 3600000;     //=1h

    @Autowired
    private UserDetailsService userDetailsService;

    Algorithm algorithm = null;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());

    }

    public TokenDTO createAccessToken(String username, List<String>roles){
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        var accessToken = getAccessToken(username,roles,now,validity);
        var refreshToken = getAccessToken(username,roles,now);
        return new TokenDTO(username,true,now,validity,accessToken,refreshToken);
    }

    private String getAccessToken(String username, List<String> roles, Date now) {
    }

    private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
    }


}