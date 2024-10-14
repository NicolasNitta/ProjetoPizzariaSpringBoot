package springteste.com.cursospring.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import springteste.com.cursospring.enumVerdadeiro.Categoria;
import springteste.com.cursospring.enumVerdadeiro.Sabor;
import springteste.com.cursospring.enumVerdadeiro.Tamanho;

@Getter
@Setter

public class PizzaDTO {
    
    private Long id;
    @NotBlank
    private String nome;
    @Positive
    private double preco;
    private boolean disponivel;
    private Tamanho tamanho;
    private Sabor sabor;
    private Categoria categoria;
}
