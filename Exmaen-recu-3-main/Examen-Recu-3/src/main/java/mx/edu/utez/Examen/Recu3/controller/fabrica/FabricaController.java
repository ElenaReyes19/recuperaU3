package mx.edu.utez.Examen.Recu3.controller.fabrica;


import mx.edu.utez.Examen.Recu3.model.fabrica.Fabrica;
import mx.edu.utez.Examen.Recu3.service.fabrica.FabricaService;
import mx.edu.utez.Examen.Recu3.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-recu/fabricante/")
@CrossOrigin(origins = {"*"})
public class FabricaController {
    @Autowired
    private FabricaService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Fabrica>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Fabrica>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Fabrica>> insert(
            @RequestBody FabricaDto fabricanteDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(fabricanteDto.getFabricante()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/searchById/")
    public ResponseEntity<List<Fabrica>> searchFabricanteById() {
        List<Fabrica> fabricantes = service.searchFabricanteById();
        return new ResponseEntity<>(fabricantes, HttpStatus.OK);
    }

    @GetMapping("/searchNombre/")
    public ResponseEntity<List<Fabrica>> searchFabricanteByNombre() {
        List<Fabrica> fabricantes = service.searchFabricanteByNombre();
        return new ResponseEntity<>(fabricantes, HttpStatus.OK);
    }

    @GetMapping("/searchFabricante/")
    public ResponseEntity<List<Fabrica>> searchFabricante() {
        List<Fabrica> fabricantes = service.searchFabricanteByNombreAndProducto();
        return new ResponseEntity<>(fabricantes, HttpStatus.OK);
    }
}
