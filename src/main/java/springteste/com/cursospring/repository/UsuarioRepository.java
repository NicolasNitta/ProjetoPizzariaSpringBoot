package springteste.com.cursospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import springteste.com.cursospring.model.Usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    UserDetails findByLogin(String login);

}