package com.tools.springBoot.project.interfaceService;


import com.tools.springBoot.project.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface IpersonaService {
    public List<Persona> listar();
    public Optional<Persona> listarId(int id);
    public int save(Persona p);
    public void delete(int id);
}
