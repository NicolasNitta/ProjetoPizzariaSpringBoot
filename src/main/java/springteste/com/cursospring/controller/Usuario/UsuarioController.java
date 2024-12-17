package springteste.com.cursospring.controller.Usuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.Usuario.UsuarioDTO;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class UsuarioController {
    
    private final UsuarioService userService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastroUsuario(@RequestBody @Valid UsuarioDTO dto, UriComponentsBuilder builder) {
        UsuarioDTO userDTO = userService.criarUsuario(dto);
        URI endereco = builder.path("/usuario/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(endereco).body(userDTO);
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> buscarTodosUsuarios(@PageableDefault (size = 10)Pageable paginacao){
       Page <UsuarioDTO> userDTO = userService.buscarTodosUsuarios(paginacao);
       return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioId(@RequestParam @Valid Long id) {
        UsuarioDTO userDTO = userService.buscarUsuarioId(id);
        return ResponseEntity.ok(userDTO);
    }
    
    
    
}
