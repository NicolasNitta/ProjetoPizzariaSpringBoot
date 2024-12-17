package springteste.com.cursospring.config;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import springteste.com.cursospring.model.Usuario.Usuario;

@Service
public class TokenService {
    
    public String criarToken(Usuario usuario){
        try{
        Algorithm algoritmo = Algorithm.HMAC256("1234");
        LocalDateTime dataExpiracao = LocalDateTime.now().plusHours(2);
        return JWT.create().withIssuer("DankiCode Pizzaria")
            .withSubject(usuario.getLogin())
            .withExpiresAt(dataExpiracao.toInstant(ZoneOffset.of("-03:00")))
            .sign(algoritmo);
            
    }catch(JWTCreationException e){
        throw new RuntimeException("Erro ao criar Token", e);
    }
        
    }
}
