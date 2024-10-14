package springteste.com.cursospring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.Pizza;
import springteste.com.cursospring.model.PizzaDTO;
import springteste.com.cursospring.repository.PizzaRepository;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PizzaDTO> buscarTodos(){
        return pizzaRepository.findAll().stream().map(p -> modelMapper.map(p, PizzaDTO.class)).
        collect(Collectors.toList()); //o stream serve para criar uma corrente de objeto, semelhante ao foreach
    }

    public PizzaDTO buscarPorID(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(pizza, PizzaDTO.class);
    }

    public PizzaDTO atualizarPizza(Long id, PizzaDTO dto) {
        Pizza pizza = modelMapper.map(dto, Pizza.class);
        pizza.setId(id);
        pizzaRepository.save(pizza);
        return modelMapper.map(pizza, PizzaDTO.class);

    }

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }

}
