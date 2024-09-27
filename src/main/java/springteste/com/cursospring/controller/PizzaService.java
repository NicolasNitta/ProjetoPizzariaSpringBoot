package springteste.com.cursospring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.Pizza;
import springteste.com.cursospring.model.PizzaDTO;
import springteste.com.cursospring.repository.PizzaRepository;

@Service
@RequiredArgsConstructor

public class PizzaService {
    
    private final PizzaRepository pizzaRepository;

    private final ModelMapper modelMapper;

    public PizzaDTO criarPizza(PizzaDTO dto){
        Pizza pizza = modelMapper.map(dto, Pizza.class);
        pizzaRepository.save(pizza);

        return modelMapper.map(pizza, PizzaDTO.class);
    }

}
