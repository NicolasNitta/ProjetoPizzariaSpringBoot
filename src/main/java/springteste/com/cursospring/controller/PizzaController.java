package springteste.com.cursospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.PizzaDTO;
import springteste.com.cursospring.repository.PizzaRepository;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor

public class PizzaController {
    
    private final PizzaService pizzaService;

    @PostMapping    
    public void cadastrar(@RequestBody @Valid PizzaDTO dto){
        pizzaService.criarPizza(dto);
    }

    @GetMapping
    public List<PizzaDTO> buscarTodos() {
        return pizzaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public PizzaDTO buscarPorID(@PathVariable Long id){
        return pizzaService.buscarPorID(id);
    }

    @PutMapping("/{id}")
    public PizzaDTO atualizarPizza(@PathVariable @NotNull Long id, @Valid @RequestBody PizzaDTO dto) {
        PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id, dto);
        return pizzaAtualizada;
    }

    @DeleteMapping("/{id}")
    public void deletarPizza(@PathVariable @NotNull Long id){
        pizzaService.excluir(id);
    }
    
}
