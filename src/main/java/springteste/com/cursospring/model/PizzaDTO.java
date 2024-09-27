package springteste.com.cursospring.model;


import lombok.Getter;
import lombok.Setter;
import springteste.com.cursospring.enumVerdadeiro.Sabor;
import springteste.com.cursospring.enumVerdadeiro.Tamanho;

@Getter
@Setter

public class PizzaDTO {
    private String nome;
    private double preco;
    private boolean disponivel;
    private Tamanho tamanho;
    private Sabor sabor;
}
