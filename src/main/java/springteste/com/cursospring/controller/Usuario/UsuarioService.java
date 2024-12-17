package springteste.com.cursospring.controller.Usuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import springteste.com.cursospring.config.CriptografiaSenha;
import springteste.com.cursospring.model.Usuario.Usuario;
import springteste.com.cursospring.model.Usuario.UsuarioDTO;
import springteste.com.cursospring.repository.UsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RestController
@RequestMapping("/usuario")
@AllArgsConstructor

@Service
public class UsuarioService implements UserDetailsService{

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioDTO criarUsuario(UsuarioDTO dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        
        //criptografando a senha
        String senhaCriptografada = CriptografiaSenha.criptografia(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);
        
        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public Page<UsuarioDTO> buscarTodosUsuarios(Pageable paginacao) {
        
        return usuarioRepository.findAll(paginacao).map( p -> modelMapper.map(p, UsuarioDTO.class));
    }

    public UsuarioDTO buscarUsuarioId(Long id) {
        Usuario user = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(user, UsuarioDTO.class);
    }

   
    
}
