package com.empresa.apiRest_DataPrint.WebSecurityConfigurer;


import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.empresa.apiRest_DataPrint.DTO.UsuarioResponseDTO;
import com.empresa.apiRest_DataPrint.excepciones.BlogAppException;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;

@Component
    public class JwtUtil implements Serializable {
    private final static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

        private static final long serialVersionUID = -3553931089359371862L;

        public static final long JWT_TOKEN_VALIDITY = 1 * 60 * 60; // Duración - 1 hora

        @Value("${jwt.secret}")
        private String secret;
    private SecretKey key;
        /*
        public String generateAccessToken(Authentication authentication){
            Usuarios usuarioPrincipal = (Usuarios) authentication.getPrincipal();
            Claims claims = Jwts.claims().setSubject(((Usuarios) authentication.getPrincipal()).getCorreo());
            claims.put("roles", ((Usuarios) authentication.getPrincipal()).getRoles());
            return Jwts.builder()
                    .setSubject(usuarioPrincipal.getCorreo())
                    .claim("roles",((Usuarios) authentication.getPrincipal()).getRoles())
                    .setIssuer("AppDataPrint")
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                    .signWith(SignatureAlgorithm.HS512,secret)
                    .compact();
        }


    //public String obtenerUsernameDelJWT(String token) {
       // Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
     //   return claims.getSubject();
    //}
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Firma JWT no valida");
        }
        catch (MalformedJwtException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no valida");
        }
        catch (ExpiredJwtException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT caducado");
        }
        catch (UnsupportedJwtException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no compatible");
        }
        catch (IllegalArgumentException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"La cadena claims JWT esta vacia");
        }
    }
    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    public Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    public String refreshToken(UsuarioResponseDTO jwtDto) throws ParseException {
        JWT jwt = JWTParser.parse(jwtDto.getTokenDeAcceso());
        JWTClaimsSet claims = jwt.getJWTClaimsSet();
        String nombreUsuario = claims.getSubject();
        List<String> roles = (List<String>)claims.getClaim("roles");

        return Jwts.builder()
                .setSubject(nombreUsuario)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

         */

 

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("ROLE").toString();
    }

    public Claims extractAllClaims(String token) {
        Claims claims;
       return claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        //return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("Roles", authorities)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000))
                .compact();
    }
    private String createToken(UserDetails userDetails) {
        return Jwts.builder()
                .claim("ROLE", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(",")))
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, key).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    public String refreshToken(UsuarioResponseDTO jwtDto) throws ParseException {
        JWT jwt = JWTParser.parse(jwtDto.getTokenDeAcceso());
        JWTClaimsSet claims = jwt.getJWTClaimsSet();
        String nombreUsuario = claims.getSubject();
        List<String> roles = (List<String>)claims.getClaim("roles");

        return Jwts.builder()
                .setSubject(nombreUsuario)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + JWT_TOKEN_VALIDITY))
                //.signWith(key, SignatureAlgorithm.HS256)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

}



