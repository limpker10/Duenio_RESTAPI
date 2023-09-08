package pe.edu.tecsup.duenioapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.duenioapi.entities.Duenio;
import pe.edu.tecsup.duenioapi.services.DuenioService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DuenioController {
    private static final Logger logger = LoggerFactory.getLogger(DuenioService.class);
    @Autowired
    private DuenioService duenioService;
    @GetMapping("/duenio")
    public ResponseEntity<List<Duenio>> obtenerDuenios() {
        try {
            List<Duenio> duenios = duenioService.findAll();
            logger.info("duenios encontrados: " + duenios.size());

            if (duenios.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(duenios);
            }
        } catch (Exception e) {
            logger.error("Error al obtener duenios", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/Duenio/{id}")
    public ResponseEntity<Duenio> obtenerDuenioPorId(@PathVariable Integer id) {
        try {

            Duenio duenios = duenioService.findById(id);

            if (duenios != null) {
                return ResponseEntity.status(HttpStatus.OK).body(duenios);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/Duenio")
    public ResponseEntity<Duenio> crearDuenio(@RequestBody Duenio duenio) {
        try {
            duenioService.save(duenio);
            logger.info("duenio creado: " + duenio);
            return ResponseEntity.status(HttpStatus.CREATED).body(duenio);
        } catch (Exception e) {
            logger.error("Error al crear duenio", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/Duenio/{id}")
    public ResponseEntity<String> eliminarDuenio(@PathVariable Integer id) {
        try {
            if (!duenioService.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El duenio con ID " + id + " no se encuentra.");
            }
            duenioService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("El duenio con ID " + id + " ha sido eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el duenio.");
        }
    }
}
