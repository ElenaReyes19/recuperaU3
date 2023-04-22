package mx.edu.utez.Examen.Recu3.service.product;

import mx.edu.utez.Examen.Recu3.model.product.Product;
import mx.edu.utez.Examen.Recu3.model.product.ProductRepository;
import mx.edu.utez.Examen.Recu3.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Product>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "Ok"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Product> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,200,"OK"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Product> insert(Product producto){
        if (this.repository.existsByNombre(producto.getNombre())){
            return new CustomResponse<>(
                    null,true,400,"Este producto ya esta registrado"
            );
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(producto),
                false,
                200,
                "Prodcuto registrado con exito"

        );
    }

    public List<Product> searchProducto(){
        return repository.searchProductoByNombre();
    }

    public List<Product> search(){
        return repository.searchProductByFabricante();
    }
}
