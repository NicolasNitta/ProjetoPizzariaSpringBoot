package springteste.com.cursospring.controller.Pizza;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.Pizza.Pizza;
import springteste.com.cursospring.model.Pizza.PizzaDTO;
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

    public Page<PizzaDTO> buscarTodos(Pageable paginacao){
        return pizzaRepository
            .findAll(paginacao)
            .map( p -> modelMapper.map(p, PizzaDTO.class));
        //.findAll().stream().map(p -> modelMapper.map(p, PizzaDTO.class)).
        //collect(Collectors.toList()); //o stream serve para criar uma corrente de objeto, semelhante ao foreach
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
