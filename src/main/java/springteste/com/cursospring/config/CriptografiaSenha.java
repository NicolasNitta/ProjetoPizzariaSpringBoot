package springteste.com.cursospring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Configuration
@RestControllerAdvice
public class CriptografiaSenha {
    
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String criptografia( String password ){
        return encoder.encode(password);
    }
}
