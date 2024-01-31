package com.rktpdyfk.TradingMatchingService.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static com.rktpdyfk.TradingMatchingService.jwt.JwtFilter.AUTHORIZATION_HEADER;

@Component
//토큰 생성 및 유효성 검증
public class TokenProvider implements InitializingBean {
    private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
    private static final String AUTHORITIES_KEY = "auth";
    private final String secret;
    private final long tokenValidityInMilliseconds;
    private Key key;
    //

    //yml에서 설정한 시크릿값 가져옴
    public TokenProvider(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds) {
        this.secret = secret;
        this.tokenValidityInMilliseconds = tokenValidityInSeconds*1000;
    }

    //빈이 생성이되고 주입을 받은후 secret값을 Base64 Decode하여 Key변수에 할당
    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Decoders.BASE64.decode((secret));
        this.key = Keys.hmacShaKeyFor(keyBytes);
        logger.info("Initialized TokenProvider with secret: {}", secret);
    }

    //Authentication 객체의 권한 정보를 이용해 토큰을 생성
    public String createToken(Authentication authentication){
        //권한들 뽑아오기
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        //yaml에서 설정한 토큰 만료시간값으로 설정
        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);
        //
        logger.info("Created JWT token for user: {}", authentication.getName());
        //jwt 토큰을 생성해서 리턴
        return Jwts.builder() //
                .setSubject(authentication.getName())//아이디
                .claim(AUTHORITIES_KEY, authorities)//권한
                .signWith(key, SignatureAlgorithm.HS512)//알고리즘
                .setExpiration(validity)//유효기간
                .compact();
    }

    //토큰을 매개변수로 받아서 토큰에서 Authentication 권한객체를 가져옴.
    public Authentication getAuthentication(String token){

        //토큰을 이용해 claims 생성
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        //claims에서 권한 정보를 추출
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        //이를 이용해 user 객체 생성
        User principal = new User(claims.getSubject(), "", authorities);

        //
        logger.info("Extracted authorities from JWT token for user: {}", principal.getUsername());
        //최종적으로 Authentication 객체를 리턴
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    //토큰을 파리미터로 받아서 토큰의 유효성 검증을 수행
    public boolean validateToken(String token) {
        try {
            //토큰을 파싱해보고
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            logger.info("Validated JWT token");
            return true; //익셉션 발생X 정상일때
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            logger.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            logger.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            logger.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            logger.info("JWT 토큰이 잘못되었습니다.");
        }
        return false; //문제 발생 시
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            //Bearer "토큰" 식으로 담겨있으니까 문자열 인덱스 7번째부터 토큰이 있으므로 토큰만 가져옴.
            return bearerToken.substring(7);
        }

        return null;
    }

    //토큰의 Claim 디코딩
    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //토큰에서 회원 정보 추출 <-- 안되는거같음..
    public String getUsername(String token){
        String username = String.valueOf(getAllClaims(token).get("username"));
        return username;
//        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
//        return claims.get("username", String.class);
    }
}