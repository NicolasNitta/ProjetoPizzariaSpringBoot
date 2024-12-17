package springteste.com.cursospring.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import springteste.com.cursospring.repository.UsuarioRepository;

@AllArgsConstructor
@Component
public class Filter extends OncePerRequestFilter{

    private final TokenService tokenService;

    private final UsuarioRepository repository;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = buscarToken(request);
        if (token != null) {

            var usuarioLogin = tokenService.buscarUsuarioToken(token);
            var usuario = repository.findByLogin(usuarioLogin);

            var autenticador = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities()); //recebe um usuario, um null e um getAuthorities(Controle de acesso como por ex: Administrador, usuario comum, etc)

            SecurityContextHolder.getContext().setAuthentication(autenticador); //Serve para validar na aplicação e liberar as funcionalidades
        }
      
        filterChain.doFilter(request, response);
    }
    
    private String buscarToken(HttpServletRequest request){

        var authorization = request.getHeader("Authorization");
     
        if (authorization != null){

        return authorization.replace("Bearer ", "");
        }

        return null;
    }

}
