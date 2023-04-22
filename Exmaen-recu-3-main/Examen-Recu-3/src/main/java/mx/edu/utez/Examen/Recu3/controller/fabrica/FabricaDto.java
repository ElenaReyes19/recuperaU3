package mx.edu.utez.Examen.Recu3.controller.fabrica;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Examen.Recu3.model.fabrica.Fabrica;
import mx.edu.utez.Examen.Recu3.model.product.Product;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FabricaDto {
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 1, max = 100)
    private String nombre;

    private List<Product> producto;


    public Fabrica getFabricante() {
        return new Fabrica(
                getId(),
                getNombre(),
                getProducto()
        );
    }
}
