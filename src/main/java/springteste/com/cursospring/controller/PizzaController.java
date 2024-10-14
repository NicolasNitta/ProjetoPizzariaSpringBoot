package springteste.com.cursospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.PizzaDTO;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    
}
