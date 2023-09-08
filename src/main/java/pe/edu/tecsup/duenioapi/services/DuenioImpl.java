package pe.edu.tecsup.duenioapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.duenioapi.entities.Duenio;
import pe.edu.tecsup.duenioapi.repositories.DuenioRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DuenioImpl implements DuenioService{

    @Autowired
    private DuenioRepository duenioRepository;

    @Override
    public List<Duenio> findAll() {
        return duenioRepository.findAll();
    }

    @Override
    public Duenio findById(Integer id) {
        return duenioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
    }

    @Override
    public void save(Duenio duenio) {
        duenioRepository.save(duenio);
    }

    @Override
    public void deleteById(Integer id) {
        duenioRepository.deleteById(id);
    }

    @Override
    public Boolean existsById(Integer id) {
        return duenioRepository.existsById(id);
    }
}
