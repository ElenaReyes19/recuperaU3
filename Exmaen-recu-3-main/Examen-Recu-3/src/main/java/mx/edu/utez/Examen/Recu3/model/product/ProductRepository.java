package mx.edu.utez.Examen.Recu3.model.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByNombre(String name);

    @Query(
            value = "SELECT p.* FROM producto p WHERE p.precio >= ( SELECT AVG(p2.precio) FROM producto p2 WHERE p2.fabricante_id = p.fabricante_id);",
            nativeQuery = true
    )
    List<Product> searchProductoByNombre();

    @Query(
            value ="SELECT p.* FROM producto p JOIN fabricante f ON p.fabricante_id = f.id WHERE f.nombre = 'Asus' OR f.nombre = 'Hewlett-Packard' OR f.nombre = 'Seagate'",
            nativeQuery = true
    )
    List<Product> searchProductByFabricante();

    boolean existsById(Long id);
}
