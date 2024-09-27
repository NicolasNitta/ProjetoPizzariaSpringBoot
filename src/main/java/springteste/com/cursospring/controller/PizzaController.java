package springteste.com.cursospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.PizzaDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(name = "/pizzas")
@RequiredArgsConstructor

public class PizzaController {
    
    private final PizzaService pizzaService;

    @PostMapping    
    public void cadastrar(@RequestBody PizzaDTO dto){
        pizzaService.criarPizza(dto);
    }
}
