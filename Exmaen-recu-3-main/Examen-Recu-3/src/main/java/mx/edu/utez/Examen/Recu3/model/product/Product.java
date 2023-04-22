package mx.edu.utez.Examen.Recu3.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Examen.Recu3.model.fabrica.Fabrica;
import javax.persistence.*;

@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false, referencedColumnName = "id")
    private Fabrica fabricante;
}
