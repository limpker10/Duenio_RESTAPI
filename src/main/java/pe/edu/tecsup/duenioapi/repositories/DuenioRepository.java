package pe.edu.tecsup.duenioapi.repositories;

import org.springframework.data.repository.CrudRepository;
import pe.edu.tecsup.duenioapi.entities.Duenio;

import java.util.List;

public interface DuenioRepository extends CrudRepository<Duenio,Integer> {
    @Override
    List<Duenio> findAll();
}
