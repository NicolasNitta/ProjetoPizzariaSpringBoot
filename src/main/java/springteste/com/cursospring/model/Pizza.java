package springteste.com.cursospring.model; 

import springteste.com.cursospring.enumVerdadeiro.Categoria;
import springteste.com.cursospring.enumVerdadeiro.Sabor;
import springteste.com.cursospring.enumVerdadeiro.Tamanho;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Pizza")
@AllArgsConstructor
@NoArgsConstructor
@Data // Substitui o @Getter, @Setter e o HashCode @ToString e @RequiredArgsConstructor
//@Getter serve para substituir os métodos get do código
//@Setter serve para substituir os métodos set do código
//@EqualsAndHashCode serve para identificação e agrupação objetos
public class Pizza {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    private double preco;

    private boolean disponivel;

    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    @Enumerated (EnumType.STRING)
    private Sabor sabor;
    @Enumerated (EnumType.STRING)
    private Categoria categoria;
}
