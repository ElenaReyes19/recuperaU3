package mx.edu.utez.Examen.Recu3.controller.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Examen.Recu3.model.fabrica.Fabrica;
import mx.edu.utez.Examen.Recu3.model.product.Product;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 1, max = 100)
    private String nombre;
    private Double precio;

    private Fabrica fabricante;

    public Product getProducto(){
        return new Product(
                getId(),
                getNombre(),
                getPrecio(),
                getFabricante()
        );
    }
}
