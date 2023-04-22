package mx.edu.utez.Examen.Recu3.service.fabrica;

import mx.edu.utez.Examen.Recu3.model.fabrica.Fabrica;
import mx.edu.utez.Examen.Recu3.model.fabrica.FabricaRepository;
import mx.edu.utez.Examen.Recu3.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class FabricaService {
    @Autowired
    private FabricaRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Fabrica>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "Ok"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Fabrica> getOne(Long id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Fabrica> insert(Fabrica fabricante) {
        if (this.repository.existsByNombre(fabricante.getNombre())) {
            return new CustomResponse<>(
                    null, true, 400, "Esta fabricante ya esta registrado"
            );
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(fabricante),
                false,
                200,
                "Fabricante registrado con exito"

        );
    }

    public List<Fabrica> searchFabricanteById() {
        return repository.searchFabricanteById();
    }

    public List<Fabrica> searchFabricanteByNombre() {
        return repository.searchFabricanteByNombre();
    }

    public List<Fabrica> searchFabricanteByNombreAndProducto() {
        return repository.searchFabricanteByNombreAAndProducto();
    }

}
