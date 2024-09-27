package springteste.com.cursospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springteste.com.cursospring.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    
}
