package springteste.com.cursospring.controller.Usuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import springteste.com.cursospring.config.TokenService;
import springteste.com.cursospring.model.Usuario.CredenciaisDTO;
import springteste.com.cursospring.model.Usuario.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
@AllArgsConstructor

public class LoginController {
    
    private final TokenService tokenService;
    private final AuthenticationManager autenticador; //metodo service do proprio springSecutiry

    @PostMapping
    public ResponseEntity validacaoCredenciais(@RequestBody @Valid CredenciaisDTO dto, UriComponentsBuilder builder) {
        UsernamePasswordAuthenticationToken token = 
            new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword()); //como se fosse outro dto com os atributos sendo passado pelos parametros

        Authentication autenticacao = autenticador.authenticate(token);
        return ResponseEntity.ok(tokenService.criarToken((Usuario) autenticacao.getPrincipal()));
    }
    
}
