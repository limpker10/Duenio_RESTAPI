package pe.edu.tecsup.duenioapi.services;

import pe.edu.tecsup.duenioapi.entities.Duenio;

import java.util.List;

public interface DuenioService {
    public List<Duenio> findAll();

    public Duenio findById(Integer id);

    public void save(Duenio libro);

    public void deleteById(Integer id);

    public Boolean existsById(Integer id);
}
