package springteste.com.cursospring.pizza;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PizzaDTO {
    private String nome;
    private double preco;
    private boolean disponivel;
    private Tamanho tamanho;
    private Sabor sabor;
}
