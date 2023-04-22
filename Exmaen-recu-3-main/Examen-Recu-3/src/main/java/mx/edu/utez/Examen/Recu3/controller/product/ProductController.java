package mx.edu.utez.Examen.Recu3.controller.product;

import mx.edu.utez.Examen.Recu3.model.product.Product;
import mx.edu.utez.Examen.Recu3.service.product.ProductService;
import mx.edu.utez.Examen.Recu3.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-recu/producto/")
@CrossOrigin(origins = {"*"})
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Product>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Product>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Product>> insert(
            @RequestBody ProductDto productoDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(productoDto.getProducto()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/searchProducto/")
    public ResponseEntity<List<Product>> searchProducto(){
        List<Product> productos = service.searchProducto();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Product>> search(){
        List<Product> productos = service.search();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}
